from flask import Flask, jsonify, abort, make_response, request, url_for
import os
from datetime import datetime  
from datetime import timedelta  


app = Flask(__name__)

#'''
products = [
    {
        "id": 1,
        "price": 1000,
        "product": "celular",
        "quantity": 320
    },
    {
        "id": 2,
        "price": 1000,
        "product": "televisao",
        "quantity": 320
    }
]
index = 2
#'''

'''
products = []
index = 0
'''
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
    if not request.json or not 'product' in request.json:
        return jsonify({'error': 'bad request'}), 404
        
    product_name = request.json['product']
    price = request.json['price']
    quantity = request.json['quantity']

    product = [product for product in products if(product['product'] == product_name)]

    if(product != []):
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

@app.route('/products/delete', methods=['DELETE'])
def delete_product():
    product_name = request.json['product']

    product = [product for product in products if(product['product'] == product_name)]

    if len(product) == 0:
        return jsonify({'status': 'product '+str(product_name)+' does not exists'}), 404
    if not request.json:
        return jsonify({'error': 'bad request'}), 404

    products.remove(product[0])

    return jsonify({'status': 'product '+product[0]['product']+' deleted'}), 200

@app.route('/products/delete/<int:id>', methods=['DELETE'])
def delete_product_id(id):
    product_id = id

    product = [product for product in products if(product['id'] == product_id)]

    if len(product) == 0:
        return jsonify({'status': 'product with id '+str(id)+' does not exists'}), 404

    products.remove(product[0])

    return jsonify({'status': 'product '+product[0]['product']+' deleted'}), 200


@app.route('/products/update/<int:id>', methods=['PUT'])
def update_by_id(id):
    product_id = id
    try:
        product_name = request.json['product']
    except:
        pass
    try:
        product_price = request.json['price']
    except:
        pass
    try:
        product_quantity = request.json['quantity']
    except:
        pass

    product = [product for product in products if(product['id'] == product_id)]

    if len(product) == 0:
        return jsonify({'status': 'product with id '+str(id)+' does not exists'}), 404
    
    old_product = product[0]['product']

    for product in products:
        if product['id'] == int(id):
            try:
                product['product'] = product_name
            except:
                pass
            try:
                product['price'] = product_price
            except:
                pass
            try:
                product['quantity'] = product_quantity
            except:
                pass

    return jsonify({'status': 'product '+old_product+' updated'}), 200

@app.route('/products', methods=['POST'])
def get_products_by_id():
    if not request.json or not 'products' in request.json:
        return jsonify({'error': 'bad request'}), 404

    result = []
    for i in range(len(request.json['products'][0])):
        index = i+1
        product = [product for product in products if(product['id'] == request.json['products'][0]['id'+str(index)])]
        if len(product) > 0:
            result.append([make_public_product(product) for product in product])

    return jsonify({'products': result}), 200
    
@app.route('/products/news', methods=['POST'])
def create_more_than_one():
    if not request.json or not 'products' in request.json:
        return jsonify({'error': 'bad request'}), 404
    
    for i in range(len(request.json['products'][0])):        
        product_name = request.json['products'][i]['name']
        price = request.json['products'][i]['price']
        quantity = request.json['products'][i]['quantity']

        product = [product for product in products if(product['product'] == product_name)]
        if(product != []):
            return jsonify({'status': 'product '+product_name+' already exists'}), 409

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
    
    return jsonify({'result':'new products created'}), 201

@app.route("/")
def heartbeat():
    return jsonify({'product service heartbeat <3': 'okay'}), 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', debug=True)