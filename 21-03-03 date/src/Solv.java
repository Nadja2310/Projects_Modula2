import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Solv {
    //Домашнее задание:
    //Создать LocalDate своего рождения. Вывести день недели, день в году.
    // Создать LocalDate своего др в текущем году. Создать сегодняшний день и сравнить,
    // что раньше, ваш др или сегодня, и на сколько дней.
    //Посчитать, сколько дней осталось до нового года. Нельзя ничего захардкодить.
    public int calculateDaysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate silvester1 = LocalDate.of(today.getYear() + 1, 1, 1);
        LocalDate silvester2 = LocalDate.of(
                today.getYear(), 12, 31
        );

        int dayUntilNewYear1 = silvester1.getDayOfYear() - today.getDayOfYear();
        int dayUntilNewYear2 = silvester2.getDayOfYear() - today.getDayOfYear();

        return dayUntilNewYear2;
    }

    public void birthdays(String myBirthday) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate dateBirthday = LocalDate.parse(myBirthday, formatter);
        System.out.println(dateBirthday);
        System.out.println("Day of week: " + dateBirthday.getDayOfWeek());
        System.out.println("Day of year: " + dateBirthday.getDayOfYear());

        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(today.getYear(),
                dateBirthday.getMonth(),
                dateBirthday.getDayOfMonth());
        LocalDate endOfYear = LocalDate.of(today.getYear(), 12, 31);

        long leftDays = 0;
        if (today.isBefore(date)) {
            leftDays = ChronoUnit.DAYS.between(today, date);
        } else {
            leftDays = ChronoUnit.DAYS.between(date, today);
            leftDays = (dateBirthday.getDayOfYear() +
                    (endOfYear.getDayOfYear() - today.getDayOfYear()));
        }
        System.out.println("Until the day of birth left - "
                + leftDays);

    }
}
