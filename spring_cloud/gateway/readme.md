注意一点，gateway基于spring5 webflux响应式编程，
所以性能要比阻塞式好，但是gateway不能引入web依赖，
因为其引入了web-flux依赖，并且web服务器为netty

之前我在父工程中引入了web依赖，导致gateway子模块启动失败，
去掉父工程web依赖，在需要子模块中导入web依赖解决
*有没有其他解决办法?