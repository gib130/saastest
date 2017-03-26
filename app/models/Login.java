package models;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;

/**
 * Данный класс необходим для обработки формы логина.
 * Используется для валидации двух типов.
 *
 * 1. В качестве валидации отдельных полей используются аннотации
 * @Email - строка соответствует адресу эл. почты
 * @Required - обязательное поле.
 *
 * Для задания осмысленного сообщения при наарушении данного ограничения,
 * используется параметр message.
 * @Email(message = "Некорректный адрес электронной почты")
 *
 *
 * 2. Валидация на уровне формы с помощью метода String validate()
 * Когда нет возможности ограничиться валидацией полей по отдельности,
 * например когда условие валидации зависит от соответствия значений нескольких полей,
 *
 * Валидация форма логина проходит тогда, когда email и пароль соответствуют (хэши совпадают и т.д. и т.п.)
 *
 *
 */
public class Login {
    //todo необходим добавить message для всех аннотаций отдельных полей
    @Email(message = "Некорректный адрес электронной почты")
    @Required
    public String email;

    //todo обязательное поле
	@Password(message = "Некорректный пароль")
    @Required
    public String password;

    /**
     * Производит валидацию формы.
     *
     * Подсказка: Воспользоваться методом User.authenticate(email, password)
     *
     * @return null в случае, если валидация успешна. Строку с ошибкой в противном случае.
     */
    public String validate() {
        //todo
        return User.authenticate(email,password);
    }
}
