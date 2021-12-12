package filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MaintenanceFilter implements Filter {

  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		InputStream is = null;
		Properties props = null;
		
		try {
			//lê o arquivo application.properties, localizado junto com as classes da aplicação
			is = MaintenanceFilter.class.getResourceAsStream("/application.properties");
			
			//cria o objeto Properties e o popula com base nas propriedades definidas em application.properties
			props = new Properties();
			props.load(is);
		}finally {
			if(is!=null) {
				//fecha a input steam
				is.close();
			}
		}
		boolean maintenance = Boolean.valueOf(props.getProperty("maintenance"));
		
		if(!maintenance) {
			//site nao está em manutenção. Processar a requisicao normalemente
			chain.doFilter(request, response);
		}else {
			// site em manutenção. Direciona o usuario para maintance.jsp e nao processa a requisicao
			request.getRequestDispatcher("maintenance.jsp").forward(request,response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
