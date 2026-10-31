INSERT INTO wanted_criminals (name, nickname, reward, latitude, longitude, location_note, difficulty, armed, has_crew, escape_master) VALUES
('Kael Draven', 'Void Reaper', 25000.00, 34.0522, -118.2437, 'Last seen near Kepler Station', 8, TRUE, TRUE, TRUE),
(NULL, 'Ghost Pilot', 12000.00, NULL, NULL, 'Signal lost somewhere in the Orion belt', 7, FALSE, FALSE, TRUE),
('Mira Voss', 'Starlace', 5000.00, 12.4000, 45.7000, NULL, 4, FALSE, FALSE, FALSE),
('Tor Bannock', 'Iron Maw', 18000.00, -22.1000, 130.5000, NULL, 9, TRUE, TRUE, FALSE),
(NULL, 'Nebula Jack', 3500.00, NULL, NULL, 'Rumored to hide on a mining colony near Titan', 3, FALSE, TRUE, FALSE),
('Lena Okafor', 'Black Comet', 40000.00, 61.8000, -9.3000, NULL, 10, TRUE, TRUE, TRUE);

INSERT INTO hunt_logs (criminal_id, success, notes) VALUES
(1, FALSE, 'Target escaped through an asteroid field.'),
(1, FALSE, 'Ambushed by his crew near Kepler Station.'),
(1, TRUE, 'Captured after disabling his engines with an EMP.'),
(2, FALSE, 'Lost the ship on radar after a hyperspace jump.'),
(2, FALSE, 'Tracked a false signal to an empty cargo hauler.'),
(3, TRUE, 'Arrested without resistance at a trading post.'),
(3, TRUE, 'Caught while trying to sell stolen navigation charts.'),
(4, FALSE, 'Heavy weapons fire forced a retreat.'),
(5, TRUE, 'Found hiding in a cargo container on Titan.'),
(5, FALSE, 'Bribed the dock guards and slipped away.'),
(6, FALSE, 'Vanished before the boarding party arrived.'),
(6, FALSE, 'Booby-trapped hideout, nobody inside.');
