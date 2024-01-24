INSERT INTO "instrument_types" ("name")
VALUES ('Corde'),
    ('Vent'),
    ('percussion');
-- Insérer des données dans la table des catégories d'instruments
INSERT INTO "instrument_categories" ("name", "level")
VALUES ('Débutant', 1),
    ('Standard', 2),
    ('Pro', 3);
-- Insérer des données dans la table des instruments
INSERT INTO "instruments" ("name", "type", "category", "preview")
VALUES (
        'violon',
        1,
        1,
        'https://firebasestorage.googleapis.com/v0/b/file-server-f5b74.appspot.com/o/market-instrument%2F7a288a127edf4ef1044ba1ac132703be.jpg?alt=media&token=849b5f90-e165-4287-87ae-8c356bf801f8'
    ),
    (
        'flûte',
        2,
        2,
        'https://firebasestorage.googleapis.com/v0/b/file-server-f5b74.appspot.com/o/market-instrument%2F706c8acbcbd446282e0b38ff632b88e5.jpg?alt=media&token=4e034932-0540-4541-a036-acfc6eb8f9e8'
    ),
    (
        'batterie',
        3,
        3,
        'https://firebasestorage.googleapis.com/v0/b/file-server-f5b74.appspot.com/o/market-instrument%2F919bbbc03a03f71651b8b58490925387.jpg?alt=media&token=5a3db696-5947-46a6-a570-a03ce91cd64c'
    );
INSERT INTO "prices" ("created_at", "price", "instrument_id")
VALUES ('NOW()', 4000, 1);
INSERT INTO "prices" ("created_at", "price", "instrument_id")
VALUES ('NOW()', 6000, 2);
INSERT INTO "prices" ("created_at", "price", "instrument_id")
VALUES ('NOW()', 1000, 3);