USE cms;

DELIMITER $$

CREATE PROCEDURE GetAppointmentsPerMonth()
BEGIN
SELECT
    YEAR(appointment_time) AS year,
    MONTH(appointment_time) AS month,
    COUNT(*) AS total_appointments
FROM appointment
GROUP BY YEAR(appointment_time), MONTH(appointment_time)
ORDER BY year, month;
END$$

DELIMITER ;

