package testCases;

import objectRepository.CreateTeamRepo;
import objectRepository.LoginRepository;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateTeam {

    JavascriptExecutor js;
    int playing11 = 0;
    int actualSize = 0;
    WebDriverWait Wait;
    List<WebElement> PlayerList = null;
   CreateTeamRepo createTeam;
    WebDriver driver;
    boolean getDoneTutorial = true;
    int Matchcount = 1;
      int temp1 = 0;
    int count = 0;
    int alreadyCreateTeam = 0;
    LoginRepository loginRepo;
    boolean flag = true;
    List<WebElement> teamCount = null;

    public CreateTeam(WebDriver driver, WebDriverWait wait) {
        Wait = wait;
        js = (JavascriptExecutor) driver;
        createTeam = PageFactory.initElements(driver, CreateTeamRepo.class);
        loginRepo = PageFactory.initElements(driver, LoginRepository.class);

    }

    public void Select_The_Match( ) throws Exception{

        Thread.sleep(2000);
        List<WebElement> matchlist = null;

        try {
            for (int i = 0; i < 10; i++) {
                js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
            }

            // Scroll up
            js.executeScript("$(\".scroling_div\").scrollTop(0);");
        } catch (Exception e) {
            e.printStackTrace();
        }

        matchlist = createTeam.getMatchList();

        System.out.println("Number of matches:" + matchlist.size());

        Thread.sleep(1000);
        matchlist.get(Matchcount).click();

        if (getDoneTutorial) {

            Thread.sleep(4000);
            createTeam.getDoneTutorial().click();

        }

        //getDoneTutorial = false;
    }

    public void TeamSelection(String WK, String Bat, String AR, String Bowl) throws Exception{
        String st;
        if (flag) {
            st = createTeam.getfooterButton().getText();
        } else {
            st = createTeam.getCreateNewTeamBtn().getText();
        }

        System.out.println("Button TEXT : " + st);
        switch (st.toUpperCase()) {
            // when 0 teams
            case "CREATE NEW TEAM": {
                teamCount = createTeam.getTeamCount();
                if (teamCount.size() >= 10) {
                    driver.navigate().back();
                    // Thread.sleep(2000);
                    Matchcount++;
                    Select_The_Match();
                }

                if (flag) {
                    Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getfooterButton())).click();
                } else {
                    Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getCreateNewTeamBtn())).click();
                }

                count++;
                temp1 = alreadyCreateTeam + count;
                System.out.println("Already Created team :" + alreadyCreateTeam + "Newly Created Team :" + count
                        + "Total team Created : " + temp1);
                if (temp1 >= 10) {
                    // Thread.sleep(2000);
                    driver.navigate().back();

                    Matchcount++;
                    count = 0;
                    System.out.println("10 Team created in previous Match, Now switch to another match : " + Matchcount);
                    Select_The_Match();
                }
                break;
            }

            // when team > 0
            case "My Teams": {
                System.out.println("Already Created Team = " + createTeam.getTeamCount().size());
                //alreadyCreateTeam = Integer.parseInt(createTeam.getTeamCount().getText());
                if (alreadyCreateTeam == 10) {
                    // Thread.sleep(3000);
                    driver.navigate().back();
                    Matchcount++;
                    alreadyCreateTeam = 0;
                    Select_The_Match();
                } else {
                    Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getfooterButton())).click();
                    teamCount = createTeam.getTeamCount();
                    if (teamCount.size() >= 10) {
                        driver.navigate().back();
                        // Thread.sleep(2000);
                        Matchcount++;
                        Select_The_Match();
                    }
                    // Thread.sleep(2000);
                    createTeam.getCreateNewTeamBtn().click();
                    flag = false;
                    count++;
                }
                break;
            }

            // allready 10 teams.
            default:
                if (teamCount.size() >= 10) {
                    System.out.println("Default team count : " + teamCount.size());
                    if (!createTeam.getfooterButton().isDisplayed()) {
                        driver.navigate().back();
                        Matchcount++;

                    }
                }
        }

        //code for player selection
        // Thread.sleep(1000);


        Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getTutorialSkipButton())).click();
        createTeam.getCR_sort().click();

        List<WebElement> playerType = createTeam.getplayerType();

        List<WebElement> list1 = null;

        // Thread.sleep(1000);
        list1 = createTeam.getMemberSelectionList();
        //SelectPlayerInList(0, WK, list1, playerType.get(0), playerType.get(1));
        selectPlayerWithOutRandom(WK, list1, playerType.get(0), playerType.get(1));

        // Thread.sleep(1000);
        list1 = createTeam.getMemberSelectionList();
        //SelectPlayerInList(1, Bat, list1, playerType.get(1), playerType.get(2));
        selectPlayerWithOutRandom(Bat, list1, playerType.get(1), playerType.get(2));


        // Thread.sleep(1000);
        list1 = createTeam.getMemberSelectionList();
        //SelectPlayerInList(2, AR, list1, playerType.get(2), playerType.get(3));
        selectPlayerWithOutRandom(AR, list1, playerType.get(2), playerType.get(3));


        list1 = createTeam.getMemberSelectionList();
        //SelectPlayerInList(3, Bowl, list1, playerType.get(3), null);
        selectPlayerWithOutRandom(Bowl, list1, playerType.get(3), null);
        String[] arrOfStr =  createTeam.getselectedplaying11members().getText().split(" /");
        playing11 = Integer.parseInt(arrOfStr[0]);

        if (playing11 == 11) {
            Wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
            Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getNextbtn())).click();
            captainSelection();
        } else
            System.out.println("wrong selection");
    }

    public void captainSelection( ) {
        System.out.print("start caption selection ");
        int c = 0, vc = 1;
        try {
            List<WebElement> selectCaptainlist = createTeam.getCaptainBox();
            List<WebElement> selectViceCaptainlist = createTeam.getViceCaptainBox();

            /*
             * if (selectCaptainlist.size() >= 0 && selectViceCaptainlist.size() >= 0) {
             *
             * Random randomGenerator = new Random(); c =
             * randomGenerator.nextInt(selectCaptainlist.size()); vc =
             * randomGenerator.nextInt(selectViceCaptainlist.size() / 2);
             *
             * System.out.println("Captain List Size = " + selectCaptainlist.size() +
             * "Vice Captain List size = " + selectViceCaptainlist.size());
             *
             * System.out.println("captain = " + c + "ViceCaptain :" + vc); }
             *
             *
             *
             * if (c == vc) { captainSelection(); }
             */

            Thread.sleep(1000);
            Wait.until(ExpectedConditions.elementToBeClickable(selectCaptainlist.get(c))).click();
            Thread.sleep(1000);
            Wait.until(ExpectedConditions.elementToBeClickable(selectViceCaptainlist.get(vc))).click();
        } catch (Exception e) {
            e.printStackTrace();
            captainSelection();
        }

        Wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
        Wait.until(ExpectedConditions.elementToBeClickable(createTeam.getNextbtn())).click();
    } // funcation close


    public void verifyMatchListandSelection( ) throws Exception{
        Select_The_Match();

        if (alreadyCreateTeam == 10) {
            // Thread.sleep(3000);
            Matchcount++;
            System.out.println(
                    "Footer Buttton <MyTeam> Already 10 Team created in this match, Now switch to another match : "
                            + Matchcount);

            alreadyCreateTeam = 0;
            driver.navigate().back();
            Select_The_Match();
        }

    } // Verify match list function close


    //player selection without generating Random Number's
    public void selectPlayerWithOutRandom(String size, List<WebElement> PlayerListdemo, WebElement first,
                                          WebElement second) throws Exception{
        int i;
        PlayerList = PlayerListdemo;
        if (first.isEnabled()) {
            actualSize = Integer.parseInt(size);
            String[] arrOfStr =  createTeam.getselectedplaying11members().getText().split(" /");
            playing11 = Integer.parseInt(arrOfStr[0]);

            for (i = 0; i < actualSize; i++) {
                System.out.println(" selection start ");
                Thread.sleep(500);
                PlayerList.get(i).click();

            }
           arrOfStr =  createTeam.getselectedplaying11members().getText().split(" /");
            playing11 = Integer.parseInt(arrOfStr[0]);

            if (second != null)
                second.click();
            actualSize = 0;

        }
    }

}
