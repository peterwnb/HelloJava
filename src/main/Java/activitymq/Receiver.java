package mq.activitymq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by zzq on 16-10-20.
 */
public class Receiver {

    public static void main(String[] args) {
        //ConnectionFactory连接工厂
        ConnectionFactory connectionFactory;
        //是JMS客户端连接JMS Provider:他是用来处理消息路由与传递的消息
        Connection connection=null;
        //创建连接
        Session session;
        //消息目的地
        Destination destination;
        //消息接收者
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("FirstQueue");
            messageConsumer = session.createConsumer(destination);
            while(true){
                TextMessage textMessage = (TextMessage) messageConsumer.receive(500000);
                if(null!=textMessage){
                    System.out.println("收到消息:" + textMessage.getText());
                }else{
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            if(null!=connection){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
