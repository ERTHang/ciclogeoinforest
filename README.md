# CicloGeoInfoRest
Não estável - testado apenas no windows com problemas de desempenho.
## Um servidor REST feito para o aplicativo Biketrilhas

## Necessário: 
    - JDK 8+ - rodei com o 11 no meu pc
    - Maven 3.6
    - Apache TomEE 8
    - PostgreSQL 12 - não testei em outras versões
    - PostGIS
    - Backup do banco recuperado com o cli do postgres
    - IDE - use a sua IDE de preferência, mas só configurei no Netbeans 8, não tentei outros.

## Configuração:
    - no arquivo src/main/resources/META-INF/persistence.xml tem algumas propriedades que dependem de algumas informações:
        - jdbc:postgresql://localhost:5432/{NOME DO SEU BANCO NO POSTGRESQL}"
        - usuario e senha abaixo é o do postgresql que você configurou na instalação

## Paths: 

### GET:
URL | QUERY/PATH PARAM | RESPONSE
------------ | ------------- | -------------
http://localhost:8083/ciclogeoinforest/ciclo/server/cidade | NULL | Lista de cidades
http://localhost:8083/ciclogeoinforest/ciclo/server/bairro | NULL | Lista de bairros
http://localhost:8083/ciclogeoinforest/ciclo/server/dificuldade | NULL | Lista de dificuldades
http://localhost:8083/ciclogeoinforest/ciclo/server/superficie | NULL | Lista de superficies
http://localhost:8083/ciclogeoinforest/ciclo/server/categoria | NULL | Lista de categorias
http://localhost:8083/ciclogeoinforest/ciclo/server/tipo | NULL | Lista de tipos
http://localhost:8083/ciclogeoinforest/ciclo/server/layer/{codt} | codt | layer do codt
http://localhost:8083/ciclogeoinforest/ciclo/server/naogeografico | tipo/cod | naogeografico(?) com tipo e/ou cod
http://localhost:8083/ciclogeoinforest/ciclo/server/trilha/{codt} | codt | trilha com o codt
http://localhost:8083/ciclogeoinforest/ciclo/server/feature | bbox1/bbox2/bbox3/bbox4/x/y/srs/widthh/heightt | (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/auxiliar/{codigoTrilha} | codigo da trilha | informações auxiliares sobre a trilha
http://localhost:8083/ciclogeoinforest/ciclo/server/route | lat_orig/lon_orig/lat_dest/lon_dest | rota dando as coordenadas (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/byteimage | codimg/codwp | (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/kml/{codtr} | codtr | arquico kml da trilha (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/map | srs/transparent/tiled/bbox1/bbox2/bbox3/bbox4/widthh/heightt/cql_filter | map (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/osm | maxlat/minlon/maxlon/minlat/scale/zoom | osmmap (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/login/{login}/{senha} | login/senha | verifica se login e senha batem
http://localhost:8083/ciclogeoinforest/ciclo/server/loginusuario/{login}/{senha} | login/senha | verifica se login e senha batem, se sim retorna o usuario
http://localhost:8083/ciclogeoinforest/ciclo/server/email/{email} | email | verifica se o email existe no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/trilhauser/{login}/{senha}/{cod} | login/senha/cod | retorna a trilha para o usuario se login e senha conferem
http://localhost:8083/ciclogeoinforest/ciclo/server/trilhauser/{login}/{senha}/ | login/senha | retorna as trilhas do usuario se login e senha conferem
http://localhost:8083/ciclogeoinforest/ciclo/server/waypointuser/{login}/{senha}/{cod} | login/senha/cod | retorna o waipoint para o usuario se login e senha conferem
http://localhost:8083/ciclogeoinforest/ciclo/server/waypointuser/{login}/{senha}/ | login/senha | retorna os waypoints do usuario se login e senha conferem


### Post:
URL | QUERY/PATH PARAM | RESPONSE
------------ | ------------- | -------------
http://localhost:8083/ciclogeoinforest/ciclo/server/bairro | JSON(bairro) | insere o bairro no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/cidade | JSON(cidade) | insere a cidade no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/usuario | JSON(usuario) | insere o usuario no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/waypoint | JSON(waypoint) | insere o waypoint no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/oldtrilha | JSON(oldtrilha) | insere a trilha antiga no banco (?)
http://localhost:8083/ciclogeoinforest/ciclo/server/trilha | JSON(trilha) | insere a trilha no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/trilhamobile | JSON(trilhamobile) | insere a trilha através do app

### PUT:
URL | QUERY/PATH PARAM | RESPONSE
------------ | ------------- | -------------
http://localhost:8083/ciclogeoinforest/ciclo/server/bairro/{baicod} | JSON(bairro)/baicod | atualiza o bairro no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/cidade/{cidcod} | JSON(cidade)/cidcod | atualiza a cidade no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/usuario/{login}/{senha} | JSON(usuario)/login/senha | atualiza o usuario se login e senha conferem

### DELETE:
URL | QUERY/PATH PARAM | RESPONSE
------------ | ------------- | -------------
http://localhost:8083/ciclogeoinforest/ciclo/server/bairro/{baicod} | baicod | deleta o bairro no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/cidade/{cidcod} | cidcod | deleta a cidade no banco
http://localhost:8083/ciclogeoinforest/ciclo/server/usuario/{login}/{senha} | login/senha | deleta o usuario se login e senha conferem
http://localhost:8083/ciclogeoinforest/ciclo/server/waypoint/{waypoint_codwp}/{login}/{senha} | waypoint_codwp/login/senha | deleta o waypoint se login e senha do criador conferem
http://localhost:8083/ciclogeoinforest/ciclo/server/trilha/{trilhadados_codt}/{login}/{senha} | trilhadados_codt/login/senha | deleta a trilha se login e senha do criador conferem
