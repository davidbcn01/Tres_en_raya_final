package sample.Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Controller  implements Initializable {
@FXML Button btn01;
@FXML Button btn02;
@FXML Button btn03;
@FXML Button btn04;
@FXML Button btn05;
@FXML Button btn06;
@FXML Button btn07;
@FXML Button btn08;
@FXML Button btn09;
@FXML RadioButton HxH;
@FXML Text j1;
@FXML Text j2;
@FXML TextField nj1;
@FXML TextField nj2;
@FXML RadioButton CxH;
@FXML RadioButton CxC;
@FXML Button btnStart;
boolean turno = false;
List<Button> llista_buttons = new ArrayList<>();
List<Button> llista_buttons2 = new ArrayList<>();
int n = 9;
public Scene scene;
public Stage stage;


    public void clickButton(javafx.event.ActionEvent actionEvent) {  //metode per fer click en els botons
        if (HxH.isSelected()) {  //Mode de Jugador vs Jugador
            antiBug();
            Button b = (Button) actionEvent.getSource();
            System.out.println(b.getId());
            if (!turno) {
                b.setText("X");
                turno = true;
                b.setDisable(true);


            } else {
                b.setText("O");
                turno = false;
                b.setDisable(true);

            }
            WinCondition();
        }

        if (CxH.isSelected()) { //Mode de Computer vs Jugador
            //Per a que la màquina faci el seu moviment cal clicar dins la pantalla on estan els botons

            antiBug();

            Button b = (Button) actionEvent.getSource();
            System.out.println(b.getId());
            if (!turno) {
                b.setText("X");
                turno = true;
                b.setDisable(true);
                if (b.getId().equals("btn01")) {
                    llista_buttons2.remove(btn01);
                }

                if (b.getId().equals("btn02")) {
                    llista_buttons2.remove(btn02);
                }
                if (b.getId().equals("btn03")) {
                    llista_buttons2.remove(btn03);
                }
                if (b.getId().equals("btn04")) {
                    llista_buttons2.remove(btn04);
                }
                if (b.getId().equals("btn05")) {
                    llista_buttons2.remove(btn05);
                }
                if (b.getId().equals("btn06")) {
                    llista_buttons2.remove(btn06);
                }
                if (b.getId().equals("btn07")) {
                    llista_buttons2.remove(btn07);
                }
                if (b.getId().equals("btn08")) {
                    llista_buttons2.remove(btn08);
                }
                if (b.getId().equals("btn09")) {
                    llista_buttons2.remove(btn09);
                }

                n--;
            } else {
                if (turno) {
                    Random random = new Random();
                    int i = random.nextInt(n);


                    llista_buttons2.get(i).setText("O");
                    turno = false;
                    llista_buttons2.remove(i);
                    n--;
                }

            }
            WinCondition();
        }

    }





    public void cleanGame(){ // metode per netejar els botons
                 btn01.setText(" ");
                 btn02.setText(" ");
                 btn03.setText(" ");
                 btn04.setText(" ");
                 btn05.setText(" ");
                 btn06.setText(" ");
                 btn07.setText(" ");
                 btn08.setText(" ");
                 btn09.setText(" ");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    //btn01.setText("BTN");
    }

    public void clickClose(ActionEvent actionEvent) {
        System.out.println("Hola");
    }

    public void clickHxH(ActionEvent actionEvent) {
        //metode per mostrar els diferents camps i botons desitjats quan es selecciona jugar humà vs humà
        if (HxH.isSelected()){
            clean();
            j1.setVisible(true);
            nj1.setVisible(true);
            j2.setVisible(true);
            nj2.setVisible(true);
            btnStart.setVisible(true);
        }
    }

    public void clickCxH(ActionEvent actionEvent) {
            //metode per mostrar els diferents camps i botons desitjats quan es selecciona jugar computer vs humà
        if(CxH.isSelected()){
            clean();
            j1.setVisible(true);
            nj1.setVisible(true);
            btnStart.setVisible(true);
        }
    }

    public void clickCxC(ActionEvent actionEvent) {
        //metode per mostrar els diferents camps i botons desitjats quan es selecciona jugar computer vs computer
        clean();
        btnStart.setVisible(true);
    }
    public void clean(){
        j1.setVisible(false);
        nj1.setVisible(false);
        j2.setVisible(false);
        nj2.setVisible(false);
        btnStart.setVisible(false);
    }

    public void ComputervsComputer(){
        //metode per simular una tirada de la computer
        llista_buttons.add(btn01);
        llista_buttons.add(btn02);
        llista_buttons.add(btn03);
        llista_buttons.add(btn04);
        llista_buttons.add(btn05);
        llista_buttons.add(btn06);
        llista_buttons.add(btn07);
        llista_buttons.add(btn08);
        llista_buttons.add(btn09);

        Random random = new Random();



            int i = random.nextInt(n);
            n--;

            if (!turno) {
                llista_buttons.get(i).setText("X");
                turno = true;
                llista_buttons.remove(i);

            } else {
                llista_buttons.get(i).setText("O");
                turno = false;
                llista_buttons.remove(i);
            }

}




        public void turnosCxC(){
        //metode per simular la partida de Computer vs Computer
          if(CxC.isSelected()){
                cleanGame();
        
        for(int o =0; o<9;o++) {
            ComputervsComputer();
            if (WinCondition()){
                break;
}
            }
        }
        n = 9;
        turno=false;
    }

    public void antiBug(){
        //metode per desactivar els radiobutons per elegir el mode de joc
        /*Aquest metode s'utilitza per evitar un bug que es dona quan es comença una partida a un mode de joc
          i es canvia a un altre sense que la partida hagi acabat*/
        HxH.setVisible(false);
    CxH.setVisible(false);
    CxC.setVisible(false);
}
    public void pressStart(ActionEvent actionEvent) {
        //metode que utilitza el botó start per iniciar el joc
        cleanGame();
        antiBug();
        turnosCxC();
        btn01.setDisable(false);
        btn02.setDisable(false);
        btn03.setDisable(false);
        btn04.setDisable(false);
        btn05.setDisable(false);
        btn06.setDisable(false);
        btn07.setDisable(false);
        btn08.setDisable(false);
        btn09.setDisable(false);
        n=9;
        turno = false;
        if(CxH.isSelected()){
            llista_buttons2.add(btn01);
            llista_buttons2.add(btn02);
            llista_buttons2.add(btn03);
            llista_buttons2.add(btn04);
            llista_buttons2.add(btn05);
            llista_buttons2.add(btn06);
            llista_buttons2.add(btn07);
            llista_buttons2.add(btn08);
            llista_buttons2.add(btn09);
        }


    }

    public  boolean  WinCondition () {
        //metode per comprobar la victoria de X i O o empat entre aquestes

        if ((btn01.getText().equals("X") && btn02.getText().equals("X") && btn03.getText().equals("X")) ||
                (btn01.getText().equals("X") && btn04.getText().equals("X") && btn07.getText().equals("X")) ||
                (btn01.getText().equals("X") && btn05.getText().equals("X") && btn09.getText().equals("X")) ||
                (btn02.getText().equals("X") && btn05.getText().equals("X") && btn08.getText().equals("X")) ||
                (btn03.getText().equals("X") && btn06.getText().equals("X") && btn09.getText().equals("X")) ||
                (btn03.getText().equals("X") && btn05.getText().equals("X") && btn07.getText().equals("X")) ||
                (btn04.getText().equals("X") && btn05.getText().equals("X") && btn06.getText().equals("X")) ||
                (btn07.getText().equals("X") && btn08.getText().equals("X") && btn09.getText().equals("X"))) {

            System.out.println("Victoria de les X("+nj1.getText()+")");
            btn01.setDisable(true);
            btn02.setDisable(true);
            btn03.setDisable(true);
            btn04.setDisable(true);
            btn05.setDisable(true);
            btn06.setDisable(true);
            btn07.setDisable(true);
            btn08.setDisable(true);
            btn09.setDisable(true);
            HxH.setVisible(true);
            CxH.setVisible(true);
            CxC.setVisible(true);
            //Popup que surt quan es detecta la victoria de X
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Partida acabada");
            alert.setHeaderText(null);
            alert.setContentText("Han guanyat les X");
            alert.showAndWait();
            return true;
        } else {
            if ((btn01.getText().equals("O") && btn02.getText().equals("O") && btn03.getText().equals("O")) ||
                    (btn01.getText().equals("O") && btn04.getText().equals("O") && btn07.getText().equals("O")) ||
                    (btn01.getText().equals("O") && btn05.getText().equals("O") && btn09.getText().equals("O")) ||
                    (btn02.getText().equals("O") && btn05.getText().equals("O") && btn08.getText().equals("O")) ||
                    (btn03.getText().equals("O") && btn06.getText().equals("O") && btn09.getText().equals("O")) ||
                    (btn03.getText().equals("O") && btn05.getText().equals("O") && btn07.getText().equals("O")) ||
                    (btn04.getText().equals("O") && btn05.getText().equals("O") && btn06.getText().equals("O")) ||
                    (btn07.getText().equals("O") && btn08.getText().equals("O") && btn09.getText().equals("O"))) {
                System.out.println("Victoria de les O("+nj2.getText()+")");
                btn01.setDisable(true);
                btn02.setDisable(true);
                btn03.setDisable(true);
                btn04.setDisable(true);
                btn05.setDisable(true);
                btn06.setDisable(true);
                btn07.setDisable(true);
                btn08.setDisable(true);
                btn09.setDisable(true);
                HxH.setVisible(true);
                CxH.setVisible(true);
                CxC.setVisible(true);
                //Popup que surt quan es detecta la victoria de O
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Partida acabada");
                alert.setHeaderText(null);
                alert.setContentText("Han guanyat les O");
                alert.showAndWait();
                return true;
            }else if(!btn01.getText().equals(" ") && !btn02.getText().equals(" ") && !btn03.getText().equals(" ") &&
                    !btn04.getText().equals(" ") && !btn05.getText().equals(" ") && !btn06.getText().equals(" ") &&
                    !btn07.getText().equals(" ") && !btn08.getText().equals(" ") && !btn09.getText().equals(" ")){
                btn01.setDisable(true);
                btn02.setDisable(true);
                btn03.setDisable(true);
                btn04.setDisable(true);
                btn05.setDisable(true);
                btn06.setDisable(true);
                btn07.setDisable(true);
                btn08.setDisable(true);
                btn09.setDisable(true);
                HxH.setVisible(true);
                CxH.setVisible(true);
                CxC.setVisible(true);
                //Popup que surt quan es detecta empat
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Partida acabada");
                alert.setHeaderText(null);
                alert.setContentText("Empat");
                alert.showAndWait();
                return true;
            }

        }
    return false;
    }


    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }




}


