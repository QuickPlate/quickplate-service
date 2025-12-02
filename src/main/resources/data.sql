INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m1', 'entree', 'Egg Fried Rice', 9.99, 'Authentic fried rice plate with diced carrots, peas, bean sprouts, signature soy glaze, and eggs.', 'images/egg-fried-rice.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m2', 'entree', 'Halal Cart Chicken Platter', 11.99, 'Diced halal chicken thighs, spicy red rice, fresh cucumber salad, and tzatziki.', 'images/halal-chicken.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m3', 'entree', 'Ground Beef Bulgogi', 10.99, 'Rice dish topped with umami ground beef, red peppers, broccoli, and spring onion.', 'images/beef-bulgogi.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m4', 'entree', 'Creamy Cajun Chicken', 11.99, 'Sliced chicken thigh with cajun seasonings, mashed potatoes, and creamy Alfredo sauce.', 'images/cajun-chicken.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m5', 'entree', 'Honey-Soy Chicken & Rice', 11.99, 'Chicken glazed with honey and soy sauce, served with rice, a sunny side up egg, and cucumber.', 'images/honey-soy-chicken.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m6', 'entree', 'Beef Burrito', 11.99, 'Signature ground beef, cilantro lime rice, black beans, lettuce, cheese, and homemade pico de gallo.', 'images/beef-burrito.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m7', 'breakfast', 'Breakfast Burrito', 9.99, 'Toasted burrito with scrambled eggs, ground beef, cheese, and hot sauce.', 'images/breakfast-burrito.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m8', 'breakfast', 'Greek Yogurt Power Bowl', 6.99, 'Healthy pick-me-up with vanilla greek yogurt, chia seeds, assorted fruits, and honey.', 'images/greek-yogurt.png')
ON CONFLICT (id) DO NOTHING;

INSERT INTO meals (id, category, name, price, description, image) VALUES 
('m9', 'breakfast', 'Royal Scrambled Eggs', 9.99, 'Classic fluffy scrambled eggs, an everything bagel with cream cheese, and assorted fruits.', 'images/scrambled-eggs.png')
ON CONFLICT (id) DO NOTHING;