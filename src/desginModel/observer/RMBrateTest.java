package desginModel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用观察者模式设计一个程序，分析“人民币汇率”的升值或贬值对进口公司进口产品成本或出口公司的出口产品收入以及公司利润率的影响。
 *
 * 分析：当“人民币汇率”升值时，进口公司的进口产品成本降低且利润率提升，出口公司的出口产品收入降低且利润率降低；当“人民币汇率”贬值时，进口公司的进口产品成本提升且利润率降低，出口公司的出口产品收入提升且利润率提升。
 *
 * 这里的汇率（Rate）类是抽象目标类，它包含了保存观察者（Company）的 List 和增加/删除观察者的方法，以及有关汇率改变的抽象方法 change(int number)；而人民币汇率（RMBrate）类是具体目标， 它实现了父类的 change(int number) 方法，即当人民币汇率发生改变时通过相关公司；公司（Company）类是抽象观察者，它定义了一个有关汇率反应的抽象方法 response(int number)；进口公司（ImportCompany）类和出口公司（ExportCompany）类是具体观察者类，它们实现了父类的 response(int number) 方法，即当它们接收到汇率发生改变的通知时作为相应的反应。
 */
public class RMBrateTest {
    public static void main(String[] args) {
        Rate rate = new RMBrate();
        Company watch1 = new ImportCompany();
        Company watch2 = new ExportCompany();
        rate.add(watch1);
        rate.add(watch2);
        rate.change(2);
    }
}

/**
  *  抽象目标：汇率
  */
abstract class Rate{
    protected List<Company> companys = new ArrayList<Company>();
    /**
     * 增加观察者方法
     */
    public void add(Company company){
        companys.add(company);
    }

    /**
     * 删除观察者方法
     */
    public void remove(Company company){
        companys.remove(company);
    }

    public abstract void change(int number);
}

/**
 * 具体目标：人民币汇率
 */
class RMBrate extends Rate{
    public void change(int number){
        for (Company obs : companys){
            ((Company)obs).response(number);
        }
    }
}

/**
 *  抽象观察者：公司
 */
interface Company{
    void response(int number);
}

/**
 *  具体观察者1：进口公司
 */
class ImportCompany implements Company{

    @Override
    public void response(int number) {
        if (number > 0){
            System.out.println("人民币汇率升值" + number + "个基点，降低了进口产品成本，提升了进口公司利润率。");
        }else if(number < 0){
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了进口产品成本，降低了进口公司利润率。");
        }
    }
}

/**
 *  具体观察者2：出口公司
 */
class ExportCompany implements Company{

    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
        }
    }
}