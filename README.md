# Етап 1: Запроектування структури проєкту

Крок 1: Відкриття Eclipse та створення нового проєкту
Запустіть Eclipse.
Оберіть робочий простір (workspace) або створіть новий.
Виберіть "File" -> "New" -> "Other".
Оберіть "Maven" -> "Maven Project" та натисніть "Next".

Крок 2: Вибір архетипу
Оберіть "Create a simple project (skip archetype selection)" та натисніть "Next".
Введіть GroupId (наприклад, com.example) та ArtifactId (наприклад, math-helper) і натисніть "Finish".

Крок 3: Додавання модулів
У вікні "Project Explorer", праворуч клікніть правою кнопкою миші на папку проєкту і оберіть "New" -> "Module".
Створіть модулі для різних частин функціоналу (наприклад, equation-input, equation-validation, database, search) і натисніть "Finish".

# Етап 2: Реалізація введення рівнянь

Крок 1: Створення класу для рівнянь
У папці equation-input створіть новий пакет (наприклад, com.example.mathhelper.equationinput).
Створіть клас Equation для представлення математичного рівняння.

Крок 2: Реалізація методу для введення рівнянь
Додайте метод у клас Equation, який приймає рядок рівняння та виконує розбір рядка для визначення правильності та невідомих.
Використовуйте регулярні вирази або інші методи для обробки введення.

Крок 3: Додавання перевірки коректності
У папці equation-validation створіть пакет (наприклад, com.example.mathhelper.equationvalidation).
Створіть клас EquationValidator, який буде містити методи для перевірки коректності рівнянь та виразів.

# Етап 3: Перевірка коректності дужок та виразу

Крок 1: Розробка функцій для перевірки дужок
В EquationValidator, додайте метод для перевірки коректності використання дужок у рівнянні.
Використовуйте стек або інші структури даних для визначення правильності використання дужок.

Крок 2: Реалізація перевірки коректності виразу
Додайте метод для перевірки коректності введеного виразу в EquationValidator.
Використовуйте регулярні вирази або інші методи для виявлення двох знаків операцій поспіль.

# Етап 4: Робота з базою даних

Крок 1: Встановлення MySQL
Завантажте та встановіть MySQL Server на ваш комп'ютер.
Крок 2: Створення схеми бази даних
Запустіть MySQL Server та використайте інтерфейс командного рядка або інструмент управління базами даних (наприклад, MySQL Workbench).
Створіть нову базу даних (наприклад, math_helper):

```bash
CREATE DATABASE math_helper;
USE math_helper;
```

Крок 3: Створення таблиці для зберігання рівнянь
Створіть таблицю для зберігання рівнянь та їхніх коренів:

```bash
CREATE TABLE equations (
id INT AUTO_INCREMENT PRIMARY KEY,
equation_text VARCHAR(255) NOT NULL,
root DOUBLE
);
```

Крок 4: Реалізація функціоналу для збереження в базі даних
У модулі database створіть пакет (наприклад, com.example.mathhelper.database) та клас EquationRepository.
Реалізуйте метод для збереження коректних рівнянь у базі даних:

```bash
public class EquationRepository {
public void saveEquation(Equation equation) {
// Використовуйте JDBC або Hibernate для вставки рівнянь у базу даних
}
}
```

# Етап 5: Пошук рівнянь за коренями

Крок 1: Реалізація методу пошуку в базі даних
В EquationRepository, додайте метод для пошуку рівнянь за заданими коренями:

```bash
public List<Equation> findEquationsByRoot(double root) {
// Використовуйте SQL-запит для пошуку рівнянь за коренем
// Повертайте список знайдених рівнянь
}
```

# Етап 6: Розробка тестів

Крок 1: Створення тестових класів
У кожному модулі створіть тестовий пакет (наприклад, com.example.mathhelper.tests) та класи для тестів.
Додайте залежності на JUnit у вашому pom.xml:

```bash
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.12</version> <!-- або остання версія -->
<scope>test</scope>
</dependency>
```

Крок 2: Написання модульних тестів
У кожному класі тестів напишіть тести для відповідних методів. Наприклад, для EquationValidator:

```bash
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EquationValidatorTest {

    @Test
    public void testEquationValidation() {
        // Створіть об'єкт EquationValidator та перевірте його методи
        assertTrue(EquationValidator.isValidEquation("2*x+5=17"));
    }

}
```

Запустіть тести, переконайтеся, що вони виконуються успішно.

Крок 3: Тестування бази даних
Для тестування бази даних використовуйте тести, які встановлюють та очищають тестові дані перед кожним запуском тесту.

Наприклад, використовуйте аннотації @Before та @After для створення та очищення тестових даних.

```bash
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EquationRepositoryTest {

    private EquationRepository equationRepository;

    @Before
    public void setUp() {
        // Ініціалізація об'єкту EquationRepository перед кожним тестом
        equationRepository = new EquationRepository();
    }

    @After
    public void tearDown() {
        // Очищення тестових даних після кожного тесту
    }

    @Test
    public void testSaveEquation() {
        // Тест збереження рівняння та перевірка, чи воно збережене в базі даних
        Equation equation = new Equation("2*x+5=17");
        equationRepository.saveEquation(equation);
        assertEquals(equation, equationRepository.findEquationsByRoot(0.0).get(0));
    }

}
```

# POM-файл для Maven-проекту

## Огляд

POM-файл (Project Object Model) визначає структуру проекту, залежності від бібліотек та плагінів Maven.

## JavaFX Залежності

- **javafx-controls, javafx-fxml, javafx-web, javafx-media:**
  - Надають JavaFX-компоненти для створення графічного інтерфейсу користувача, обробки подій, роботи з мультимедіа і т. д.

## ControlsFX

- **controlsfx:**
  - Бібліотека для розширення стандартних компонентів JavaFX, яка надає додаткові елементи керування і можливості.

## FormsFX

- **formsfx-core:**
  - Бібліотека для створення форм в JavaFX-додатках з використанням моделей даних та байндингу.

## ValidatorFX

- **validatorfx:**
  - Бібліотека для валідації форм JavaFX з можливістю вказувати правила валідації.

## Ikonli

- **ikonli-javafx:**
  - Бібліотека для відображення векторних іконок в JavaFX-додатках.

## BootstrapFX

- **bootstrapfx-core:**
  - Бібліотека, яка надає стилізацію для JavaFX, використовуючи Bootstrap CSS.

## FXGL

- **fxgl:**
  - Ігровий двигун для JavaFX, спрощує створення 2D-ігор.

## MySQL Connector

- **mysql-connector-j:**
  - Драйвер для взаємодії з базою даних MySQL з Java-додатками.

## LiveTribe JSR-223

- **livetribe-jsr223:**
  - Реалізація JSR-223, яка надає підтримку для взаємодії з движками скриптів в Java.

## mXparser

- **MathParser.org-mXparser:**
  - Бібліотека для обчислення математичних виразів і формул.

## JUnit 5

- **junit-jupiter-engine, junit-jupiter-api, junit-jupiter-params:**
  - Бібліотека для написання і запуску тестів в Java.

## JUnit Platform

- **junit-platform-suite:**
  - Платформа для запуску тестів в Java.

## Maven Plugins

- **maven-compiler-plugin:**
  - Плагін для Maven, конфігурація компілятора Java.
- **maven-surefire-plugin:**

  - Плагін для запуску тестів в Maven.

- **javafx-maven-plugin:**
  - Плагін для Maven, підтримка для JavaFX-додатків, зокрема, для збірки і запуску.
