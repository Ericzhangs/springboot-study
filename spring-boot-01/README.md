#### 1、父项目
    <groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.5.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
##### 他的父项目是

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.2.5.RELEASE</version>
        <relativePath>../../spring-boot-dependencies</relativePath>
    </parent>
  
##### 他才是用来管理SpringBoot应用里面的所有依赖版本；
称为SpringBoot的版本仲裁中心


#### 2、导入的依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    spring-boot-starter-web: 
        spring-boot-starter: 
            springboot场景启动器；帮我们导入了web模块忠正常运行所依赖的组件
            
    SpringBoot将所有的功能都抽取出来，做成一个个的starter(启动器),只需要在项目里面引入这些starter相关场景的所有依赖都会导入进来。
    要用什么功能就导入什么场景的启动器

#### 3、resources文件夹中的目录结构
- static: 保存所有的静态资源；
- templates: 保存所有的模板页面；
- application.properties: SpringBoot应用的配置文件

### 精髓
1. Springboot启动会加载大量的自动配置类
2. 我们看我们需要的功能有没有SpringBoot默认写好的自动配置类
3. 我们再来看这个自动配置类中到底配置了哪些组件；(只要我们要用的组件有了， 我们就不需要再来配置了)
4. 给容器中自定配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这些属性的值；


xxxAutoConfiguration：自动配置类；
给容器中添加组件
xxxProperties：封装了配置文件中的属性，可供我们在application.properties文件配置

### SpringBoot的启动配置原理(启动原理、运行流程、自动配置原理)
1. 创建SpringApplication()对象
```
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
    this.resourceLoader = resourceLoader;
    Assert.notNull(primarySources, "PrimarySources must not be null");
    // 保存主配置类
    this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
    // 判断当前是否是一个WEB应用
    this.webApplicationType = WebApplicationType.deduceFromClasspath();
    // 从类路径下找到META-INF/spring.factories配置的所有ApplicationContextInitializer，然后宝保存起来。
    setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
    // 从类路径下找到META-INF/spring.factories配置的所有ApplicationListener
    setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
    // 从多个配置中找到main方法的主配置类
    this.mainApplicationClass = deduceMainApplicationClass();
}
```

2. 运行run()方法
```java
public class SpringApplication {

public ConfigurableApplicationContext run(String... args) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
        // 声明一个空的IOC容器
		ConfigurableApplicationContext context = null;
		Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
		configureHeadlessProperty();

        // 从类路径下找到META-INF/spring.factories配置的所有 SpringApplicationRunListeners
		SpringApplicationRunListeners listeners = getRunListeners(args);
        // 会回调所有的SpringApplicationRunListeners.starting()方法
		listeners.starting();
		try {
            // 封装命令行参数
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
            // 准备环境
			ConfigurableEnvironment environment = prepareEnvironment(listeners, applicationArguments);
			// 创建环境完成后回调SpringApplicationRunListeners.environmentPrepared() 方法表示环境准备完成
			configureIgnoreBeanInfo(environment);
            // 打印Banner
			Banner printedBanner = printBanner(environment);
            // 创建ApplicationContext 决定创建WebIOC还是普通IOC
			context = createApplicationContext();
			exceptionReporters = getSpringFactoriesInstances(SpringBootExceptionReporter.class,
					new Class[] { ConfigurableApplicationContext.class }, context);
            // 准备上下文环境； 将environment保存到IOC中；
            // 
			prepareContext(context, environment, listeners, applicationArguments, printedBanner);
            // prepareContext()运行完成后回调所有的SpringApplicationRunListeners.contextLoaded()

            // 刷新容器； IOC初始化(如果是Web应用还会创建你嵌入式的Tomcat)；
            // 扫描、创建、加载所有组件的地方；(配置类、组件、自动配置)
			refreshContext(context);
            // 从IOC容器中获取所有的
            // 
			afterRefresh(context, applicationArguments);
			stopWatch.stop();
			if (this.logStartupInfo) {
				new StartupInfoLogger(this.mainApplicationClass).logStarted(getApplicationLog(), stopWatch);
			}
			listeners.started(context);
            // 从IOC容器中获取所有的ApplicationRunner 和 CommandLineRunner进行回调
            // ApplicationRunner先回调， CommandLineRunner在回调
			callRunners(context, applicationArguments);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, exceptionReporters, listeners);
			throw new IllegalStateException(ex);
		}

		try {
			listeners.running(context);
		}
		catch (Throwable ex) {
			handleRunFailure(context, ex, exceptionReporters, null);
			throw new IllegalStateException(ex);
		}

        // 整个SpringBoot应用启动完成之后返回启动的IOC容器；
		return context;
	}
}
```
