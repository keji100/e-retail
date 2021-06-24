### Products
@POST /product/
```
{
  "name":"Smartphone Samsung M51",
  "price":1800.00
}
```

@GET /product/
```
[
  {
    "id": "42a48c09-bf75-45de-a2df-8b8def77d13e",
    "name": "Smartphone Samsung M51",
    "price": 1800.00
  }
]
```
@GET /product/{id}
```
{
  "id": "42a48c09-bf75-45de-a2df-8b8def77d13e",
  "name": "Smartphone Samsung M51",
  "price": 1800.00
}
```

___
### Salesperson
@POST /salesperson/
```
{
  "name":"Salesperson1"
}
```

@GET /salesperson/
```
[
  {
    "id": "42abaf58-2a9d-4eeb-8b65-2b2ca733f3fb",
    "name": "Salesperson1"
  }
]
```
@GET /salesperson/{id}
```
{
  "id": "42abaf58-2a9d-4eeb-8b65-2b2ca733f3fb",
  "name": "Salesperson1"
}
```
___

### Customer
@POST /customer/
```
{
  "name":"Customer1",
  "email":"customer1@gmail.com"
}
```
@GET /customer/
```
[
  {
    "id": "85343be7-7e60-4e1d-9745-531e2b1cb497",
    "name": "Customer1",
    "email": "customer1@gmail.com"
  }
]
```
@GET /customer/{id}
```
{
  "id": "85343be7-7e60-4e1d-9745-531e2b1cb497",
  "name": "Customer1",
  "email": "customer1@gmail.com"
}
```
___

### Sales
@POST /sales/
```
{
  "salesperson":{
    "id":"42abaf58-2a9d-4eeb-8b65-2b2ca733f3fb"
  },
  "customer":{
    "id":"85343be7-7e60-4e1d-9745-531e2b1cb497"
  },
  "products":[
    {
      "id":"42a48c09-bf75-45de-a2df-8b8def77d13e"
    }
  ],
  "date":"2021-06-23"
}
```

@GET /sales/
```
[
  {
    "salesperson": {
      "id": null,
      "name": "Salesperson1"
    },
    "customer": {
      "id": null,
      "name": "Customer1",
      "email": "customer1@gmail.com"
    },
    "products": [
      {
        "id": null,
        "name": "Smartphone Samsung M51",
        "price": 1800.00
      }
    ],
    "date": null,
    "amount": 1800.00
  }
]
```
@GET /sales/{id}
```
{
  "salesperson": {
    "id": null,
    "name": "Salesperson1"
  },
  "customer": {
    "id": null,
    "name": "Customer1",
    "email": "customer1@gmail.com"
  },
  "products": [
    {
      "id": null,
      "name": "Smartphone Samsung M51",
      "price": 1800.00
    }
  ],
  "date": null,
  "amount": 1800.00
}
```
___