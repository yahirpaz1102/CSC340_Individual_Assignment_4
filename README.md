
# API Endpoints

### Base URL: http://localhost:8080/animals

## **`/all`** (GET) 
http://localhost:8080/animals/all

Gets a list of all animals in the database

### Response - a JSON array of Animal objects.
```json
[
 {
  "animalId":1,
  "name":"Dave",
  "specie":"whale",
  "age":5.0
 },
 {
  "animalId":3,
  "name":"Mike",
  "specie":
  "lizard",
  "age":6.0},
 {
  "animalId":4,
  "name":"Carl",
  "specie":"Cat",
  "age":3.0
 }
]

```

---

## **/`{animalId}`** (GET)
http://localhost:8080/animals/1

Gets an individual Animal in the system. Each Animal is identified by a numeric animalId

### Parameters
Path Variable: `animalId` <integer> - REQUIRED
```json
{
 "animalId":1,
 "name":"Dave",
 "specie":"whale",
 "age":5.0
}
```

---

## **`/name`** (GET)
http://localhost:8080/animals/name?search=Mike

Gets a list of animals with a name that contains the given string.

### Parameters
query parameter: `search` lt;String> - REQUIRED
Response - A JSON array of Animal objects.
```json
[
 { "animalId":3,
   "name":"Mike",
   "specie":"lizard",
   "age":6.0
 }
]
```

## **`/specie/{specie}`** (GET)
http://localhost:8080/animals/specie/lizard

Get a list of animals for a specific specie.

### Parameters
path variable: `specie` <String> - REQUIRED
### Response - A JSON array of Animal objects.

``` json
[
 {
  "animalId":3,
  "name":"Mike",
  "specie":"lizard",
  "age":6.0
 },
 {
  "animalId":4,
  "name":"Carl",
  "specie":"lizard",
  "age":3.0
 }
]
```
## **`/age`** (GET)
http://localhost:8080/animals/age?age=5

Gets all the animals with an age meeting the Threshold.

### Parameters
query parameter: `age` <Double> - REQUIRED

### Response - A JSON array of Animals objects.
```json
[
 {
  "animalId":1,
  "name":"Dave",
  "specie":"whale",
  "age":5.0
 },
 {
  "animalId":3,
  "name":"Mike",
  "specie":
  "lizard",
  "age":6.0
 }
]
```
## **`/new`** (POST)
http://localhost:8080/animals/new
Create a new Animal entry

### Request body
An animal object. Note that the animalId is auto assigned in the database so is not needed in the request.

```json
{
 "name": "Andrew",
 "specie": "lion",
 "age": 12
}
```
### Response - The updated list of animals

```json
[
 {
  "animalId":1,
  "name":"Dave",
  "specie":"whale",
  "age":5.0
 },
 {
  "animalId":3,
  "name":"Mike",
  "specie":"lizard",
  "age":6.0
 },
 {
  "animalId":4,
  "name":"Carl",
  "specie":"lizard",
  "age":3.0
 },
 {
  "animalId":5,
  "name":"Andrew",
  "specie":"lion",
  "age":12.0
 }
]
```
## **`/update/{animalId}`** (PUT)
http://localhost:8080/animals/update/4

Update an existing animal.

### Parameters
Path Variable: `animalId` <integer> - REQUIRED

### Request Body
An animal object with the updates.
```json
{
 "name":"Carl",
 "specie":"Cat",
 "age":7.0
}
```
### Response - the updated Animal object.
```json
{
 "animalId":4,
 "name":"Carl",
 "specie":"Cat",
 "age":7.0
}
```
## **`/delete/{animalId}`** (DELETE)
http://localhost:8080/animals/delete/4

Delete an existing Animal.

### Parameters
Path Variable: `animalId` <integer> - REQUIRED

### Response - the updated list of `Animals`.
```json
[
 {
  "animalId":1,
  "name":"Dave",
  "specie":"whale",
  "age":5.0
 },
 {
  "animalId":3,
  "name":"Mike",
  "specie":"lizard",
  "age":6.0
 },
 {
  "animalId":5,
  "name":"Andrew",
  "specie":"lion",
  "age":12.0
 }
]
```
