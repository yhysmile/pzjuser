package com.pzj.common.util;


//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;

/**
 * RabbitMQ连接类
 * 
 * @author apple
 * 
 */
public class RabbitLikeUtil {
	//
	// protected Channel channel;
	// protected Connection connection;
	// protected String endPointName;
	//
	// public RabbitLikeUtil(String endpointName) throws IOException {
	// this.endPointName = endpointName;
	//
	// // Create a connection factory
	// ConnectionFactory factory = new ConnectionFactory();
	//
	// // hostname of your rabbitmq server
	// factory.setHost("localhost");
	// //factory.setPort();
	//
	// // getting a connection
	// connection = factory.newConnection();
	//
	// // creating a channel
	// channel = connection.createChannel();
	//
	// // declaring a queue for this channel. If queue does not exist,
	// // it will be created on the server.
	// //如果声明消息队列不存在则创建该队列
	// channel.queueDeclare(endpointName, false, false, false, null);
	// }
	//
	// /**
	// * 关闭channel和connection。并非必须，因为隐含是自动调用的。
	// *
	// * @throws IOException
	// */
	// public void close() throws IOException {
	// this.channel.close();
	// this.connection.close();
	// }
	//
}
