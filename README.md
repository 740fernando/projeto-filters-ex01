### Exercício 1

- Implemente um filter que identifica se o site está em manutenção ou não. Caso esteja,
o usuário deve ser direcionado automaticamente para uma página que informa que o
site encontra-se em manutenção. Caso contrário, as requisições do usuário devem ser
processadas normalmente.
- O filter MaintenanceFilter deve interceptar todas as requisições e ler do arquivo
application.properties (localizado junto às classes do projeto) a propriedade
maintenance. Esta propriedade pode ter o valor false ou true. Caso seja false, indica
que o site está funcionando normalmente.
-  Caso seja true, indica que o site está passando por manutenção. Neste caso, o filter deve direcionar o usuário para a página
maintenance.jsp, que tem uma mensagem dizendo que o site está fora do ar
temporariamente.



<p><strong>Esta implementação de filter é um mecanismo que pode ser usado para facilitar o
processo de tirar e colocar o site no ar em períodos de manutenção.</strong></p>
