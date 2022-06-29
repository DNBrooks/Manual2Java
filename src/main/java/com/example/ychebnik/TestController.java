package com.example.ychebnik;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next_id;

    @FXML
    private Text question_text;

    @FXML
    private Button stop_id;

    @FXML
    private RadioButton radio1;

    @FXML
    private ToggleGroup answers;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    private Questions[] questions = new Questions[] {
            new Questions("Какой основной признак наружного кровотечения?", new String[] {"медленное и тягучее кровотечение", "быстрое и пульсирующие кровотечение",
                    "кровь темно-красного цвета", "кровь ярко-красного цвета"}),
            new Questions("Какой признак поверхностного венозного кровотечения?", new String[] {"кровь фонтанирует из раны", "кровь ярко-красного цвета",
                    "слабость", "кровь тёмно-красного цвета"}),
            new Questions("Каким образом наложить жгут при артериальном кровотечении?", new String[] {"прижать пальцем артерию ниже кровотечения", " на 3-5см ниже раны наложить вокруг конечности чистую ткань",
                    "доставить пострадавшего с наложенным жгутом в медицинское учреждение", "плотно приложить жгут к конечности, а также прикрепить к жгуту записку с указанием точного времени наложения"}),
            new Questions("В чём заключается оказание первой медицинской помощи при незначительных открытых ранах?", new String[] {"промыть рану содовым раствором и обработать её спиртом", "смазать рану вазелином или кремом",
                    "заклеить рану бактерицидным пластырем или наложить стерильную повязку", "промыть рану перекисью водорода (раствором марганцовки) и обработать её йодом"}),
            new Questions("Каким образом оказывается первая медицинская помощь при вывихах?", new String[] {" обеспечить повреждённой конечности покой", "наложить стерильную повязку и дать пострадавшему обильное питьё",
                    "ничего не делать", "наложить тугую повязку и дать пострадавшему обезболивающие средство"}),
            new Questions("В чём заключается оказание первой медицинской помощи при растяжениях?", new String[] {"наложить на повреждённое место холод", "наложить на повреждённое место тепло",
                    "ничего не делать", "наложить на повреждённое место тугую повязку и обеспечить ему покой"})
    };
    // Переменные для установки текущего номера вопроса и для подсчета количества верных ответов
    private int nowQuestion = 0, correctAnswers;
    // В эту переменную будет устанавливаться корректный ответ текущего вопроса
    private String nowCorrectAnswer;

    @FXML
    void initialize() {


        nowCorrectAnswer = questions[nowQuestion].correctAnswer();
        next_id.setOnAction(actionEvent -> {

            RadioButton selectedRadio = (RadioButton) answers.getSelectedToggle();
            if(selectedRadio != null) {
                // Получаем текст ответа
                String toogleGroupValue = selectedRadio.getText();

                // Сверяем ответ с корректным
                if(toogleGroupValue.equals(nowCorrectAnswer)) {
                    // Выводим информацию и увеличиваем количество верных ответов
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else
                    System.out.println("Не верный ответ");

                // Если сейчас был последний вопрос, то скрываем все поля
                if(nowQuestion + 1 == questions.length) {
                    radio1.setVisible(false); // Скрываем все поля для выбора
                    radio2.setVisible(false);
                    radio3.setVisible(false);
                    radio4.setVisible(false);
                    next_id.setVisible(false); // Скрываем кнопку ответа

                    // Показываем текст в конце
                    correctAnswers++;
                    question_text.setText("Вы ответили правильно на " + correctAnswers + " из " + questions.length  + " вопросов!");
                } else { // Если еще есть вопросы...
                    // Увеличиваем номер текущего вопроса
                    nowQuestion++;
                    // Указываем новый текст верного ответа
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    // Меняем текст вопроса в программе
                    question_text.setText(questions[nowQuestion].getQuestion());
                    // Получаем массив ответов
                    String[] answers = questions[nowQuestion].getAnswers();

                    // Преобразовываем в список (так удобнее сортировать элементы)
                    List<String> intList = Arrays.asList(answers);

                    // Сортируем в случайном порядке
                    Collections.shuffle(intList);

                    // Подставляем ответы в радио кнопки
                    radio1.setText(intList.get(0));
                    radio2.setText(intList.get(1));
                    radio3.setText(intList.get(2));
                    radio4.setText(intList.get(3));

                    // Снимаем выделение, что указал пользователь ранее
                    selectedRadio.setSelected(false);
                }

            }
        });

        stop_id.setOnAction(actionEvent -> {
            openNewScene("hello-view.fxml");
        });
    }

    public void openNewScene(String window) {
        stop_id.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));


        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent par = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("Электронное учебное пособие");
        stage.setResizable(false);
        stage.setScene(new Scene(par));
        stage.show();
    }
}