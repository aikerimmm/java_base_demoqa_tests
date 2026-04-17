package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JsSnippets {

  public void removeAds () {
      executeJavaScript("const banner = document.querySelector('#fixedban'); if (banner) banner.remove();");
      executeJavaScript("const banner = document.querySelector('footer'); if (banner) banner.remove();");}
}
