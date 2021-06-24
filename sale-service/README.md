Obs: Ids podem ser pegos após a criação, no @GET

### Products
@POST /product/
```
{
  "name":"SmartTv",
  "price":1890
}
```

### Salesperson
@POST /salesperson/
```
{
  "name":"vendedor"
}
```

### Customer
@POST /customer/
```
{
  "name":"cliente",
  "email":"cliente@gmail.com"
}
```

### Sales
@POST /sales/
```
{
  "salesperson":{
    "id":"42abaf58-2a9d-4eeb-8b65-2b2ca733f3fb"
  },
  "costumer":{
    "id":"708e7f25-6306-46ec-a91d-bee138f5698e"
  },
  "products":[
    {
      "id":"42a48c09-bf75-45de-a2df-8b8def77d13e"
    }
  ],
  "date":"2021-06-23"
}
```