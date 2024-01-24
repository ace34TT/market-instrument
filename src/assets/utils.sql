CREATE VIEW v_instruments AS
SELECT i.id as instrument_id,
    i.name AS instrument_name,
    p.price * CASE
        ic.level
        WHEN 1 THEN 1
        WHEN 2 THEN 2
        WHEN 3 THEN 4
    END AS calculated_price,
    ic.id as category_id,
    ic.name as category_name,
    it.id as type_id,
    it.name as type_name,
    i.preview
FROM instruments i
    JOIN instrument_categories ic ON i.category = ic.id
    JOIN prices p ON i.id = p.instrument_id
    JOIN instrument_types it ON it.id = i.type
WHERE p.created_at = (
        SELECT MAX(created_at)
        FROM prices
    );