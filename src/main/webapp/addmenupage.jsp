<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="style.css">
    <title>add dish</title>
</head>
<body>
<div class="container" id="container">
        <form action="MenuAdd" method="post">
            <h1>Add Menu</h1>
            <input type="text" placeholder="Dish Name" name="dname">
            <input type="text" placeholder="price" name="price">
            <select class="select-box" name="category">
                <option value="food">food</option>
                <option value="desert">desert</option>
                <option value="drinks">drinks</option>
            </select>
            <input type="file" placeholder="upload photo" name="photo">
            <button type="submit">Add</button>
        </form>
</div>
</body>

</html>
