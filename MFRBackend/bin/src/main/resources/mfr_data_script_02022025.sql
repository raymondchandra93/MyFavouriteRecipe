-- Insert Data into Recipe Table
INSERT INTO recipe (recipe_id, recipe_name, recipe_description) VALUES
(1, 'Spaghetti Bolognese', 'A classic Italian pasta dish with rich meat sauce.'),
(2, 'Chicken Curry', 'A spicy and flavorful curry with tender chicken.'),
(3, 'Caesar Salad', 'A fresh salad with romaine lettuce, croutons, and dressing.'),
(4, 'Veggie Stir Fry', 'A stir fry with assorted vegetables and soy sauce.'),
(5, 'Beef Stew', 'A hearty stew with beef, potatoes, and vegetables.'),
(6, 'Pancakes', 'Light and fluffy breakfast pancakes.'),
(7, 'Grilled Salmon', 'A healthy grilled salmon fillet with lemon.'),
(8, 'Tacos', 'Mexican dish with seasoned meat, salsa, and tortillas.'),
(9, 'Lasagna', 'Layers of pasta, meat sauce, cheese, and béchamel.'),
(10, 'Veggie Burger', 'A plant-based burger with various vegetables and spices.');

-- Insert Data into Ingredient Table
INSERT INTO ingredient (ingredient_id, ingredient_name) VALUES
(1, 'Spaghetti'),
(2, 'Ground Beef'),
(3, 'Tomato Sauce'),
(4, 'Chicken Breast'),
(5, 'Curry Powder'),
(6, 'Romaine Lettuce'),
(7, 'Croutons'),
(8, 'Soy Sauce'),
(9, 'Carrot'),
(10, 'Potatoes'),
(11, 'Flour'),
(12, 'Milk'),
(13, 'Eggs'),
(14, 'Salmon'),
(15, 'Lemon'),
(16, 'Tortillas'),
(17, 'Salsa'),
(18, 'Cheese'),
(19, 'Béchamel Sauce'),
(20, 'Veggie Patty');

-- Insert Data into RecipeIngredient Table (Bridging Table)
INSERT INTO recipeIngredient (recipe_id, ingredient_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(4, 8),
(4, 9),
(4, 10),
(5, 2),
(5, 9),
(5, 10),
(6, 11),
(6, 12),
(6, 13),
(7, 14),
(7, 15),
(8, 2),
(8, 16),
(8, 17),
(9, 1),
(9, 2),
(9, 18),
(9, 19),
(10, 20),
(10, 16);


-- Insert sample users with BCrypt hashed passwords
INSERT INTO user (user_uname, user_password) VALUES 
('john_doe', '$2a$10$7QAMzZwLOeNcFkSkefNYSOn9dNPEtG.wtw0vJfCT.5pknnpFZ6WiC'), -- password: "password123"
('alice_smith', '$2a$10$M32qkjEkOoweyBq2JoFpXe7bN6xT6D0CwP99FbwC8cXz6n5ULm9La'), -- password: "securePass!"
('bob_jones', '$2a$10$5zMltZOkX5sHEyyCZLZ5c.O9D1bHBCzvc.cAi5AaNEA6AVtkZ70fa');  -- password: "mySecretPass"
