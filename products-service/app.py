from flask import Flask, jsonify, abort, make_response, request, url_for
import os
from datetime import datetime  
from datetime import timedelta  

app = Flask(__name__)
products = []
index = 0

def represents_int(value):
    if(int(value) < 1):
        return False
    try: 
        int(value)
        return True
    except ValueError:
        return False

def make_public_product(product):
    new_product = {}
    for field in product:
        if field == 'id':
            new_product['id'] = product['id']
            new_product['uri'] = url_for('get_products', product_id=product['id'], _external=True)
        else:
            new_product[field] = product[field]
    return new_product

@app.route('/products', methods=['GET'])
def get_products():
    return jsonify({'products': [make_public_product(product) for product in products]})

@app.route('/products/new', methods=['POST'])
def create_prod():
    if not request.json or not 'product' in request.json:  # validar campos obrigatórios
        abort(400)
        
    product_name = request.json['product']
    price = request.json['price']
    quantity = request.json['quantity']

    product = [product for product in products if(product['product'] == product_name)]

    if(product != []): #conflict (entry already exists)
        return jsonify({'status': 'product '+product[0]['product']+' already exists'}), 409
    
    global index
    productId = index + 1

    product = {
        'id': productId,
        'product': product_name,
        'price': price,
        'quantity': quantity
    }

    products.append(product)

    index = productId

    return jsonify({'product': [make_public_product(product)]}), 201

@app.route('/products/delete', methods=['POST'])
def delete_product():
    product_name = request.json['product']

    product = [product for product in products if(product['product'] == product_name)]

    if len(product) == 0:
        return jsonify({'status': 'product '+str(product_name)+' does not exists'}), 404
    if not request.json:
        abort(400)

    print(product)

    products.remove(product[0])

    return jsonify({'status': 'product '+product[0]['product']+' deleted'}), 200

@app.route('/products/delete/<int:id>', methods=['POST'])
def delete_product_id(id):
    product_id = id

    product = [product for product in products if(product['id'] == product_id)]

    if len(product) == 0:
        return jsonify({'status': 'product with id '+str(id)+' does not exists'}), 404

    print(product)

    products.remove(product[0])

    return jsonify({'status': 'product '+product[0]['product']+' deleted'}), 200


@app.route("/")
def heartbeat():
    return jsonify({'product service heartbeat <3': 'okay'}), 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)