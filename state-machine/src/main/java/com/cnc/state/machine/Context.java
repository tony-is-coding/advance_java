package com.cnc.state.machine;

import com.cnc.state.machine.state.State;

/**
 * @author tony
 * @desc 基于某些特定业务和场景下，根据源状态和发生的事件，来执行下一步的流程处理逻辑，并设置一个目标状态
 * @createDate 2021/4/30 4:09 下午
 */
public class Context {
    State state;

    Order order;
}