package com.sync.sz.netty.frame.correct;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import java.util.Date;

/**
 * Created by YH on 2016-12-27.
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

  private int counter;

  @Override public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    String body = (String) msg;
    System.out.printf("The time server receiver order : " + body + " ; the counter is : " + ++counter);
    String currentTime =
        "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD QUERY";
    currentTime = currentTime + System.getProperty("line.separator");
    ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
    ctx.writeAndFlush(resp);
  }

  @Override public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    ctx.close();
  }
}
