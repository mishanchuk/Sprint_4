package ru.practicum.utill;

import org.openqa.selenium.By;

public class EnvConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String PAY_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String MANY_SCOOTER_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TIME_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TODAY_ORDER_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String PROLONG_SCOOTER_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHARGING_SCOOTER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_ORDER_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String DELIVERY_SCOOTER_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public static final int IMLICITY_TIMOUT = 150;
    public static final int EXPICITY_TIMOUT = 75;

}
