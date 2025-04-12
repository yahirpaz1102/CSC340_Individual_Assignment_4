<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create New Animal - Wild Zoo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/styles.css">
</head>
<body>
<header>
    <h1>Wild Zoo</h1>
    <nav>
        <ul>
            <li><a href="/animals/all">Home</a></li>
            <li><a href="/animals/createForm">Add Animal</a></li>

        </ul>
    </nav>
</header>

<main>
    <h2>${title}</h2>
    <div class="form-container">
        <form id="new-animal" action="/animals/new" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required placeholder="Animal Name"/>
            </div>
            <div class="mb-3">
                <label for="specie" class="form-label">Species:</label>
                <input type="text" class="form-control" id="specie" name="specie" required placeholder="Animal Species"/>
            </div>
            <div class="mb-3">
                <label for="age" class="form-label">Age:</label>
                <input type="number" class="form-control" id="age" name="age" step="0.1" required placeholder="Animal Age"/>
            </div>
            <div class="action-buttons">
                <button type="submit" class="btn btn-success">Save</button>
                <a href="/animals/all" class="btn btn-secondary">Cancel</a>
            </div>
        </form>
    </div>
</main>
</body>
</html>