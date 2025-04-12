<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${animal.name} - Animal Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<header>
    <h1>Featured Animal - ${animal.name} The ${animal.specie}</h1>
    <nav>
        <ul>
            <li><a href="/animals/all">Home</a></li>
            <li><a href="/animals/createForm">Add Animal</a></li>

        </ul>
    </nav>
</header>

<main>
    <div class="card details-card">
        <div class="card-header">
            <h2>${animal.name}</h2>
        </div>
        <div class="card-body">
            <img src="/images/${animal.specie}.jpg" alt="${animal.specie}" onerror="this.src='/images/default.jpg'" class="mb-3">
            <p><strong>ID:</strong> ${animal.animalId?c}</p>
            <p><strong>Age:</strong> ${animal.age} years</p>
            <p><strong>Species:</strong> ${animal.specie}</p>

            <div class="action-buttons">
                <a href="/animals/update/${animal.animalId?c}" class="btn btn-warning">Edit</a>
                <a href="/animals/delete/${animal.animalId?c}" class="btn btn-danger">Delete</a>
                <a href="/animals/all" class="btn btn-primary">Back to List</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>