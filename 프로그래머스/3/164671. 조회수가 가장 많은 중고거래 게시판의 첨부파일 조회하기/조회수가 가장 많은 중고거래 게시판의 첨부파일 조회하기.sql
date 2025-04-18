SELECT
    CONCAT("/home/grep/src/", A.BOARD_ID, "/", B.FILE_ID, B.FILE_NAME, B.FILE_EXT) FILE_PATH
FROM
    USED_GOODS_BOARD A
    JOIN
        USED_GOODS_FILE B
    ON 
        A.BOARD_ID = B.BOARD_ID
WHERE
    A.VIEWS = (
        SELECT 
            MAX(C.VIEWS)
        FROM
            USED_GOODS_BOARD C
    )
ORDER BY
    B.FILE_ID DESC