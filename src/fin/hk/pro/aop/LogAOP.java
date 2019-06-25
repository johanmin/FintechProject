package fin.hk.pro.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAOP {

	
	@Around("within(fin.hk.pro.*)") // aop방식에서 within설정해준것과 같음
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
							// 실행이되면 포인터가 넘어오고 그것을 받아들일 수 있는 메소드
		String signatureStr = joinpoint.getSignature().toShortString();
		
		System.out.println(signatureStr + "시작");
		
		try {
			// 실행 전			
			Object obj = joinpoint.proceed();	// 기능 실행 (포인터가 실행하는 부분)
			 
			return obj;
		
		}finally {
			
			System.out.println("실행 후 : " + System.currentTimeMillis());
			
			System.out.println(signatureStr + "종료");
		}
		
	}
}

