package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;//чтобы заработал в мейне надо убрать скоуп в пом.xml testNG - иначе только в тестах будет рабоать
import org.testng.ITestResult;

public class ListenersTestNG implements ITestListener {

    //переопределили его методы сразу скопом все через Альт Инсерт
// В ИТОГЕ ДОБАВИЛ ЛИСТЕНЕР С ПРОЕКТ AUTOMATION - THE INTERNET, НАДО ДОБАВИТЬ В ТЕСТ СЬЮТ
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
      //  ITestListener.super.onTestSuccess(result); было изначально, убрали, когда саут добавили
        System.out.println("TEST IS FAILED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
