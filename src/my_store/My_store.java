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
float cost;                 // стоимость заказа



public purchases(int id_c, String UserName_c, int delivery_c, GregorianCalendar data_c, float cost_c)
{
p_id = id_c; 
UserName = UserName_c;
delivery = delivery_c;
data = data_c;
date = FormatDate(data_c);
cost = cost_c;

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
 System.out.println ("Заказ №"+ p_id + " Пользователя " + UserName +  " от " + date + " г. на сумму " + cost); 
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
    // Формируем витрину
 public static void main(String[] args) throws IllegalAccessException{
    goods[] all_goods = new goods[4];
    all_goods[0] = new goods ( 1, "Клавиатура светящаяся", 500 , 6);
    all_goods[1] = new goods ( 2, "Мышь", 200 , 6); 
    all_goods[2] = new goods ( 3, "Монитор 24 дюйма", 8000 , 2);
    all_goods[3] = new goods ( 4, "Блок питания", 100 , 6);
    
   //формируем уже готовые заказы
   purchases[] MassPurchases = new purchases[1000];
   MassPurchases[0] = new purchases (1,"Васильев Иван Петрович",1,new GregorianCalendar(2017, 1, 1), 5000);
   MassPurchases[1] = new purchases (2,"Царь Иван Васильевич",1,new GregorianCalendar(2017, 6, 25), 500);
   MassPurchases[2] = new purchases (3,"Иванова Марфа Васильевна",1,new GregorianCalendar(2018, 4, 1), 200);
   MassPurchases[3] = new purchases (4,"Петров Марф Иванович",1,new GregorianCalendar(2017, 1, 1), 1000);

 //Начинаем диалог  с пользователем
 int what_to_do =0;
 
 
 do {
 System.out.println("1 - Показать товары");
 System.out.println("2 - Показать все заказы");
 System.out.println("3 - Показать заказы с сортировкой по дате");
 System.out.println("4 - Ввести заказ");
 System.out.println("5 - Выйти из магазина");
 
 try{
 what_to_do = Integer.parseInt(JOptionPane.showInputDialog("Выберите действие в магазине")); 
 if (what_to_do != 1 && what_to_do != 2 && what_to_do != 3 && what_to_do != 4 && what_to_do != 5)
 {throw new IllegalAccessException ( "Введен не верный пункт" ) ;}        
 } catch( IllegalAccessException e )
 {System.out.println("Вы ввели неверное действие, попробуйте еще раз");
  continue;}
  switch (what_to_do) 
 { case 5: System.out.println("Работа с магазином закончена");  break;
   case 1: // показываем все товары
 
   try{ for (int i = 0; i < all_goods.length; i++) {
        System.out.println("№" + all_goods[i].id + " "+ all_goods[i].name + " " + all_goods[i].cost + " руб. кол-во на складе - " + all_goods[i].kol);
    } 
    } 
    catch (NullPointerException e){}         
   break;
   
   case 2: //Показать все заказы
    try{
    for (int i = 0; i < MassPurchases.length; i++) {
         System.out.println(MassPurchases[i].UserName + " " + MassPurchases[i].date);
    }
    } 
    catch (NullPointerException e){}     
   break;
   case 3:
   
   Calendar sort_condition = getOrdersAfterDate();
      
   try{ for (int i = 0; i < MassPurchases.length; i++) {
         if  (CompareDates(sort_condition, MassPurchases[i].data))
         {  System.out.println(MassPurchases[i].UserName + " " + MassPurchases[i].date);} 
      }
     } catch (NullPointerException e){}    
   break;
   case 4: 
   int var=1, j = 1; // переменная ук. выводить диалог 1- выводить/0 - не выводить больше     
   int input_id, input_kol;
   float input_cost;
   float summ = 0;
   int input_delivery = 1; // признак доставляется - 1, доставлен - 0
   String UserName = JOptionPane.showInputDialog("Введите свое имя");    
   
   try{ for (int i = 0; i < all_goods.length; i++) {
        System.out.println("№" + all_goods[i].id + " "+ all_goods[i].name + " " + all_goods[i].cost + " руб. кол-во на складе - " + all_goods[i].kol);
    } 
    } 
    catch (NullPointerException e){}  
   
   do{
   input_id=Integer.parseInt(JOptionPane.showInputDialog("Введите номер товара:"));
   input_kol=Integer.parseInt(JOptionPane.showInputDialog("Введите кол-во товара:"));
   
   switch(input_id)
{
    case 1: input_cost = all_goods[0].cost; break; 
    case 2: input_cost = all_goods[1].cost; break;            
    case 3: input_cost = all_goods[2].cost; break;  
    case 4: input_cost = all_goods[3].cost; break;  
    default: input_cost = 0;
};

summ = summ + input_cost * input_kol * input_delivery;

var=Integer.parseInt(JOptionPane.showInputDialog("Хотите что-нибудь ещё проибрести? \n" +"Да - 1 \n" + "Нет - 0"));
 }  while ( var == 1);
   

   MassPurchases[3 + j] = new purchases (3+j,UserName,1,new GregorianCalendar( ), summ);
   System.out.println ("Сумма заказа " + summ + " руб."); 
   j++;
 break;
 }
  
 } while (what_to_do!= 5);
 }
}

   
    
