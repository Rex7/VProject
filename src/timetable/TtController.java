/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import scheduler.Schediuler;
import scheduler.Solution;


public class TtController implements Initializable {

    @FXML
    Spinner spinnerTime;
    @FXML
    TableView myTable;
    @FXML
    TableColumn Monday, Tuesday, Wednesday, Thursday, Friday;
    @FXML
    Label className;
    @FXML
    ChoiceBox days;

    int currentValue;
    Schediuler schediuler;
    
//    Solution S= new Solution();;
    public String ary[][][]=new String[11][24][15];
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initSpinner();
        initTable();
        days.setItems(FXCollections.observableArrayList("Complete","Monday", "Tuesday","Wednesday","Thursaday","Friday"));
        className.setText("2A");
        days.setValue("DAYS");

    }

    public void initSpinner() {

        spinnerTime.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 11));
        spinnerTime.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                System.out.println(" value " + newValue);
                final ObservableList<Subject> data;
                String[][] smu;
                String[][] d= new String[24][16];
                String daySelected=days.getValue().toString();
                int ds=0,dse=0,i,j;
                switch(daySelected){
                    case "Complete":ds=0;
                                    dse=12;
                      System.out.println("complete");
                      break;
                  case "Monday":ds=0;
                      System.out.println("monday");
                      break;
                  case "Tuesday":ds=3;
                      System.out.println("Tuesday");
                      break;
                   case "Wednesday":ds=6;
                      System.out.println("Wednesday");
                      break;
                  case "Thursday":ds=9;
                      System.out.println("Thursday");
                      break;
                      case "Friday":ds=12;
                      System.out.println("Friday");
                      break;
                  
              
              }
                
                currentValue = newValue;
                switch (newValue) {
                    case 1:className.setText("2-A:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[0][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        printMatrix(myTable, smu);
                        System.out.println(" called 1");
                        break;
                    case 2:className.setText("2-B:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[1][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[1];//schediuler.ary[0];;                            
                        printMatrix(myTable, smu);
                        System.out.println(" change is good "+days.getValue());

                        break;
                    case 3:className.setText("4-A:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[2][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[2];
                        printMatrix(myTable, smu);

                        break;
                    case 4:className.setText("4-B:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[3][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[3];
                        printMatrix(myTable, smu);
                        break;
                    case 5:className.setText("4-C:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[4][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[4];
                        printMatrix(myTable, smu);
                        break;
                    case 6:className.setText("6-A:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[5][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[5];
                        printMatrix(myTable, smu);

                        break;
                    case 7:className.setText("6-B:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[6][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[6];
                        printMatrix(myTable, smu);
                        break;
                    case 8:className.setText("6-C:"+daySelected);
                    for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[7][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[7];
                        printMatrix(myTable, smu);
                        break;
                    case 9:className.setText("8-A:"+daySelected);
                    for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[8][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[8];
                        printMatrix(myTable, smu);

                        break;
                    case 10:className.setText("8-B:"+daySelected);
                    for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[9][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[9];
                        printMatrix(myTable, smu);
                        break;
                    case 11:className.setText("8-C:"+daySelected);
                        for(i=0;i<24;i++)
                            for(j=ds;j<ds+3+dse;j++)
                                {   
                                    d[i][j]=ary[10][i][j];//schediuler.I1.arrl.get(0)[0][i][j];
                                }
                        smu = d;
                        //smu = schediuler.I1.arrl.get(0)[10];
                        printMatrix(myTable, smu);
                        break;

                }

            }

        });
        days.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
             
              
              
            }
        });
        
    }

    public void initTable() {
        int i,j;
        //String d[][]=new String[18][15];
        //final ObservableList data = FXCollections.observableArrayList(ary[0]);//schediuler.I1.arrl.get(0));
        /*for(i=0;i<18;i++)
            for(j=0;j<3;j++)
                {   
                    d[i][j]=schediuler.I1.arrl.get(0)[0][i][j];
                }
        */
        //ary=S.givarray();
        //Garray(ary);
        int k;
        for(k=0;k<11;k++){
        for (i = 0; i < 18; i++) {
            for (j = 0; j < 15; j++) {
                ary[k][i][j]=" ";
            }
        }
        }
        //System.out.println("garray"+schediuler.S.ary[0][0][0]);
        String[][] smu = ary[0];//schediuler.I1.arrl.get(0)[0];
        System.out.println("schediuler.I1.arrl.get(0 " + "schediuler.I1.arrl.get(0).length");
        
        printMatrix(myTable, smu);

    }

    void printMatrix(TableView target, String[][] source) {

        target.getColumns().clear();
        target.getItems().clear();

        int numRows = source.length;

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int i = target.getColumns().size(); i < source[rowIndex].length; i++) {
                TableColumn<String[], String> column = new TableColumn<>("Column " + i);
                final int columnIndex = i;
                column.setCellValueFactory(cellData -> {
                    String[] row = cellData.getValue();
                    String value;
                    if (row.length <= columnIndex) {
                        value = "";
                    } else {
                        value = row[columnIndex];
                    }
                    return new SimpleStringProperty(value);
                });
                target.getColumns().add(column);
            }
            target.getItems().add(source[rowIndex]);
        }
    }

    public void mySubmit(ActionEvent evt) {
        schediuler = new Schediuler();
        ary=schediuler.ary;
        System.out.println("   no selected " + currentValue);
        System.out.println("choice selec"+days.getValue());
        System.out.println(" cat"+spinnerTime.getValue());

    }
    public void Garray(String pary[][][])
    {
        int v,i,j;
        ary=pary;
        System.out.println("findd");
        for(v=0;v<11;v++)
   {
     for(i=0;i<18;i++)// i slot 0-5*3*3
            {
                for(j=0;j<15;j++)
                {
                    if(!ary[v][i][j].equals(" "))
                 System.out.print(ary[v][i][j]+"|");
                    else
                        System.out.print("$$$$");
                }
                System.out.println("");
            }
     System.out.println("............");
    }
    }

}
