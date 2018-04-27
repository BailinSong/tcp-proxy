package com.blueline.tool.proxy.tcp.handlers;

import com.blueline.tool.proxy.tcp.domain.ProxyDefinition;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;

/**
 * @author Vinicius Carvalho
 */
public class ProxyInitializer extends ChannelInitializer<SocketChannel> {


	private final ProxyDefinition proxyDefinition;
	private final AbstractTrafficShapingHandler trafficShapingHandler;

	public ProxyInitializer(ProxyDefinition proxyDefinition, AbstractTrafficShapingHandler trafficShapingHandler) {
		this.proxyDefinition = proxyDefinition;
		this.trafficShapingHandler = trafficShapingHandler;
	}



	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(trafficShapingHandler,
				new ProxyFrontendHandler(proxyDefinition));

	}
}
