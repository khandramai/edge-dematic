package org.folio.ed.client.interceptor;

import static org.folio.spring.integration.XOkapiHeaders.TENANT;
import static org.folio.spring.integration.XOkapiHeaders.TOKEN;

import java.util.Collections;

import org.folio.spring.FolioExecutionContext;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

@Component
@AllArgsConstructor
public class FeignRequestInterceptor implements RequestInterceptor {
  private final FolioExecutionContext folioExecutionContext;

  @SneakyThrows
  @Override
  public void apply(RequestTemplate template) {
    template.header(TOKEN, Collections.singletonList(folioExecutionContext.getToken()));
    template.header(TENANT, Collections.singletonList(folioExecutionContext.getTenantId()));
  }
}