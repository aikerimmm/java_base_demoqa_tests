package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {
  public void removeAds () {
      executeJavaScript("$('#fixedban').remove()");
  executeJavaScript("$('footer').remove()");
}
}
