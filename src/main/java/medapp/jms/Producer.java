package medapp.jms;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
@LocalBean
public class Producer {

    @Resource(name="java:/RemoteConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name="java:jboss/exported/jms/queue/test")
    private Destination destination;

    @Schedule(hour="*",minute="*",second = "*/1",persistent = false)
    void produceMessage(){
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);

            messageProducer.send(session.createTextMessage("Hello MDB"));
            System.out.println("------------------------------------------");
            connection.close();
            session.close();
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
