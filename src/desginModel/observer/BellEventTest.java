package desginModel.observer;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;

/**
 * 利用观察者模式设计一个学校铃声的事件处理程序。
 * 分析：在本实例中，学校的“铃”是事件源和目标，“老师”和“学生”是事件监听器和具体观察者，“铃声”是事件类。学生和老师来到学校的教学区，都会注意学校的铃，这叫事件绑定；当上课时间或下课时间到，会触发铃发声，这时会生成“铃声”事件；学生和老师听到铃声会开始上课或下课，这叫事件处理。这个实例非常适合用观察者模式实现
 * 现在用“观察者模式”来实现该事件处理模型。
 * 首先，定义一个铃声事件（RingEvent）类，它记录了铃声的类型（上课铃声/下课铃声）。
 * 再定义一个学校的铃（BellEventSource）类，它是事件源，是观察者目标类，该类里面包含了监听器容器 listener，可以绑定监听者（学生或老师），并且有产生铃声事件和通知所有监听者的方法。
 * 然后，定义铃声事件监听者（BellEventListener）类，它是抽象观察者，它包含了铃声事件处理方法 heardBell(RingEvent e)。
 * 最后，定义老师类（TeachEventListener）和学生类（StuEventListener），它们是事件监听器，是具体观察者，听到铃声会去上课或下课。
 */
public class BellEventTest {
    public static void main(String[] args) {
        BellEventSource bell = new BellEventSource();   //铃（事件源）
        bell.addPersonListener(new TeachEventListener());   //注册监听器（老师）
        bell.addPersonListener(new StuEventListener());    //注册监听器（学生）
        bell.ring(true);     //打上课铃声
        System.out.println("------------");
        bell.ring(false);     //打下课铃声
    }
}

/**
 * 铃声事件类：用于封装事件源及一些与事件相关的参数
 */
class RingEvent extends EventObject{
    private static final long serialVersionUID = 1L;
    private boolean sound;    //true表示上课铃声,false表示下课铃声
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return sound;
    }
}

/**
 * 目标类：事件源，铃
 */
class BellEventSource{
    private List<BellEventListener> listener;//监听容器

    public BellEventSource(){
        listener = new ArrayList<BellEventListener>();
    }

    /**
     * 给事件源绑定监听器
     */
    public void addPersonListener(BellEventListener ren) {
        listener.add(ren);
    }

    /**
     * 事件触发器：敲钟，当铃声sound的值发生变化时，触发事件。
     */
    public void ring(boolean sound) {
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响！");
        RingEvent event = new RingEvent(this, sound);
        notifies(event);    //通知注册在该事件源上的所有监听器
    }

    /**
     * 当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
     */
    protected void notifies(RingEvent e) {
        BellEventListener ren = null;
        Iterator<BellEventListener> iterator = listener.iterator();
        while (iterator.hasNext()) {
            ren = iterator.next();
            ren.heardBell(e);
        }
    }
}

/**
 * 抽象观察者类：铃声事件监听器
 */
interface BellEventListener {

    /**
     * 事件处理方法，听到铃声
     */
    public void heardBell(RingEvent e);
}

/**
 * 具体观察者类：老师事件监听器
 */
class TeachEventListener implements BellEventListener{

    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}

/**
 * 具体观察者类：学生事件监听器
 */
class StuEventListener implements BellEventListener{

    @Override
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}