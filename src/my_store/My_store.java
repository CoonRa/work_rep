package my_store;
import static java.lang.Boolean.TRUE;
import static java.lang.Integer.sum;
import javax.swing.*;	

import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author kuznetsova_a
 */

//класс товар
class goods {
int id, kol; // ИД товара и количество
String name; // название товара
float cost;  // стоимость товара

// конструктор единицы товара
goods (int id_c,  String name_c, float cost_c, int kol_c)
{  
id = id_c;  
name = name_c;
cost = cost_c;
kol = kol_c;
}

// метод вывести товар на экран
void print_good()
{
 System.out.println ("Товар №"+ id + ". " + name +  " цена " + cost + " руб. " + "в наличии " + kol + " шт."); 
}      
}

// класс покупка 
class purchases {
//int id, kol;                // ид товара и заказанное кол-во
//float cost;                 // итоговая цена позиции
    
int p_id;                     // id заказа
String date;                // дата заказа 
String UserName;            //заказчик
int delivery;               // статус доставки 0 - доставлен, 1 - доставляется
GregorianCalendar data;
goods[] good= new goods[4]; // до 4 наименований товаров



public purchases(int id_c, String UserName_c, int delivery_c, GregorianCalendar data_c)
{
p_id = id_c; 
UserName = UserName_c;
delivery = delivery_c;
data = data_c;
date = FormatDate(data_c);


}
// метод выдача даты в удобочитаемом формате
 public String getDate(){   
  Calendar c = new GregorianCalendar();
  SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
  String format = format1.format(c.getTime());
  return format;
  }
 
 // метод форматирование даты
  public String FormatDate(Calendar c_v){

  Calendar c = c_v;
  SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
  String format = format1.format(c.getTime());
  return format;
  
}

 void print_order()
{
 System.out.println ("Заказ №"+ p_id + " Пользователя " + UserName +  " от " + date + " г."); 
} 
 

 
}


public class My_store {
    
 
  static Calendar getOrdersAfterDate(){
     
  int enter_year = Integer.parseInt(JOptionPane.showInputDialog("Введите год в формате 2018"));
  int enter_month = Integer.parseInt(JOptionPane.showInputDialog("Введите месяц в формате 5"));
  int enter_day = Integer.parseInt(JOptionPane.showInputDialog("Введите дату"));
  
  Calendar sort_date = new GregorianCalendar(enter_year, enter_month-1, enter_day);
 
  return sort_date;
 }  
    
  public static boolean CompareDates(Calendar first_date, Calendar second_date ){
  if (first_date.after(second_date))
  {return false;} 
  else 
  {return true;}
     
 }
  
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {JOptionPane.showMessageDialog(null, "Добро пожаловать в магазин \n"  + "Выберите интересующий Вас товар");
    
    // Формируем витрину  
    goods good1 = new goods ( 1, "Клавиатура светящаяся", 500 , 6);   
    goods good2 = new goods ( 2, "Мышь", 200 , 6); 
    goods good3 = new goods ( 3, "Монитор 24 дюйма", 8000 , 2); 
    goods good4 = new goods ( 4, "Блок питания", 100 , 6); 
    

    goods[] all_goods = new goods[4];
        
    all_goods[0] = new goods ( 1, "Клавиатура светящаяся", 500 , 6);
    all_goods[1] = new goods ( 2, "Мышь", 200 , 6); 
    all_goods[2] = new goods ( 3, "Монитор 24 дюйма", 8000 , 2);
    all_goods[3] = new goods ( 4, "Блок питания", 100 , 6);

    // выводим товары
 //   good1.print_good();
 //   good2.print_good();
  //  good3.print_good();
 //   good4.print_good();
    
   //формируем уже готовые заказы
   purchases[] MassPurchases = new purchases[10];
   
   MassPurchases[0] = new purchases (1,"Васильев Иван Петрович",1,new GregorianCalendar(2017, 1, 1));
   MassPurchases[1] = new purchases (2,"Царь Иван Васильевич",1,new GregorianCalendar(2017, 6, 25));
   MassPurchases[2] = new purchases (3,"Иванова Марфа Васильевна",1,new GregorianCalendar(2018, 4, 1));
   MassPurchases[3] = new purchases (4,"Петров Марф Иванович",1,new GregorianCalendar(2017, 1, 1));
           
   purchases purchase1 = new purchases (1,"Васильев Иван Петрович",1,new GregorianCalendar(2017, 1, 1));
   purchases purchase2 = new purchases (2,"Царь Иван Васильевич",1,new GregorianCalendar(2017, 6, 25));
   purchases purchase3 = new purchases (3,"Иванова Марфа Васильевна",1,new GregorianCalendar(2018, 4, 1));
   purchases purchase4 = new purchases (4,"Петров Марф Иванович",1,new GregorianCalendar(2017, 1, 1));
    
   
   // purchase1.print_order();
 //   purchase2.print_order();
 //   purchase3.print_order();
 //   purchase4.print_order();
    
   //вывести все товары 
    try{
    for (int i = 0; i < all_goods.length; i++) {
         System.out.println("№" + all_goods[i].id + " "+ all_goods[i].name + " " + all_goods[i].cost + " руб. кол-во на складе - " + all_goods[i].kol);
    }
    } 
    catch (NullPointerException e){}   
 
 
 
    // вывести все заказы
    try{
    for (int i = 0; i < MassPurchases.length; i++) {
         System.out.println(MassPurchases[i].UserName + " " + MassPurchases[i].date);
    }
    } 
    catch (NullPointerException e){}     
    
    // вывести заказы с сортировкой по дате 
     Calendar sort_condition = getOrdersAfterDate();
      
     try{ for (int i = 0; i < MassPurchases.length; i++) {
         if  (CompareDates(sort_condition, MassPurchases[i].data))
         {  System.out.println(MassPurchases[i].UserName + " " + MassPurchases[i].date);} 
      }
     } catch (NullPointerException e){}  
     
  // ввести заказ 
   String UserName = JOptionPane.showInputDialog("Введите свое имя");
   
   
  

   
   
   
 /*

// диалог с пользователем 
int var=1,i=1; // переменная ук. выводить диалог 1- выводить/0 - не выводить больше 
int input_id, input_kol;
float input_cost;
float summ = 0;
int input_delivery = 1;

// пока пользователь не откажется от добавления товаров - выводить диалог и считать сумму
do {
input_id=Integer.parseInt(JOptionPane.showInputDialog("Введите номер товара:"));
input_kol=Integer.parseInt(JOptionPane.showInputDialog("Введите кол-во товара:"));

switch(input_id)
{
    case 1: input_cost = good1.cost; break; 
    case 2: input_cost = good2.cost; break;            
    case 3: input_cost = good3.cost; break;  
    case 4: input_cost = good4.cost; break;  
    default: input_cost = 0;
};
// создать новую покупку со свойствами ид товара, кол-во, цена и статус доставки
purchases purchase1 = new purchases(input_id, input_kol, input_cost,  input_delivery );

// ошибка, почему так нельзя присваивать?
//MyOrder[0] = new purchases(input_id, input_kol, input_cost,  input_delivery );

// Сумма покупки
summ = summ + purchase1.cost * purchase1.kol*purchase1.delivery;


var=Integer.parseInt(JOptionPane.showInputDialog("Хотите что-нибудь ещё проибрести? \n" +"Да - 1 \n" + "Нет - 0"));
}
while ( var == 1);
        
System.out.println ("Итоговая сумма " + summ + " руб."); 
*/
    }

    }
    
