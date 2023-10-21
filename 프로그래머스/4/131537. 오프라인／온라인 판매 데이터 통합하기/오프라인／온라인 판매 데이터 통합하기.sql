-- 코드를 입력하세요
SELECT
    DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE,
    PRODUCT_ID,
    USER_ID,
    SALES_AMOUNT
FROM
    ONLINE_SALE 
WHERE
    "2022-03-01" <= SALES_DATE 
    AND 
    SALES_DATE < "2022-04-01"
    
UNION ALL

SELECT
    DATE_FORMAT(SALES_DATE, "%Y-%m-%d") AS SALES_DATE,
    PRODUCT_ID,
    NULL AS USER_ID,
    SALES_AMOUNT
FROM
    OFFLINE_SALE 
WHERE
    "2022-03-01" <= SALES_DATE 
    AND 
    SALES_DATE < "2022-04-01"
    
ORDER BY
    SALES_DATE ASC,
    PRODUCT_ID ASC,
    USER_ID ASC
;