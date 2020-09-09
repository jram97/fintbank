INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('DEPF', 'Depósito.', 'S', 1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('RETF', 'Retiro.', 'S', -1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('TR01', 'Recepcion de Fondos.', 'N', 1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('TR-1', 'Envio de Fondos.', 'N', -1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('VNTA', 'Venta.', 'N', -1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('DEVLC', 'Devolución de Compra.', 'N', 1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('DEVLP', 'Devolución a cliente.', 'N', -1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('CCOM', 'Pago de Comisión.', 'N', -1);
INSERT INTO tipotransaccion (codigo, nombre, fisica, efectosaldo) VALUES ('CRCM', 'Cobro de Comisión.', 'N', 1);


INSERT INTO roles (nombre, descripcion) VALUES ('ROLE_USR', 'Rol Usuario');
INSERT INTO roles (nombre, descripcion) VALUES ('ROLE_BNK', 'Rol Agencia Bancaria');
INSERT INTO roles (nombre, descripcion) VALUES ('ROLE_ADM', 'Rol Administrador');


INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CPVR0', 'Cuenta Monedero Móvil', 300.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CPVR1', 'Cuenta Personal', 600.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CPVR2', 'Cuenta Personal Dorada', 900.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CPVR3', 'Cuenta Personal Platino', 1500.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CCVRC', 'Cuenta Comerciante Virtual', 3000.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CPYV', 'Cuenta PYME Virtual', 9000.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('CEMP', 'Cuenta Comercio Virtual', 100000.00);
INSERT INTO definicioncuenta (codigo, nombre, maximoSaldo) VALUES ('COMS', 'Cuenta Comisiones', 1000000.00);


INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) VALUES ( (select id from definicioncuenta where codigo = 'CPVR1'),  (select id from tipotransaccion where codigo = 'DEPF'), 200, 200, 0);
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) VALUES ( (select id from definicioncuenta where codigo = 'CPVR1'),  (select id from tipotransaccion where codigo = 'REFT'), 200, 200, 0);
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) VALUES ( (select id from definicioncuenta where codigo = 'CPVR1'),  (select id from tipotransaccion where codigo = 'TR01'), 200, 200, 0);
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) VALUES ( (select id from definicioncuenta where codigo = 'CPVR1'),  (select id from tipotransaccion where codigo = 'TR-1'), 200, 200, 0);
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) VALUES ( (select id from definicioncuenta where codigo = 'CPVR1'),  (select id from tipotransaccion where codigo = 'CMPC'), 200, 200, 0);
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) VALUES ( (select id from definicioncuenta where codigo = 'CPVR1'),  (select id from tipotransaccion where codigo = 'DEVLC'), 200, 200, 0);

INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) select (select id from definicioncuenta where codigo = 'CPVR0'), r.transaccion_id, (r.maximo_diario - 50), (r.maximo_operacion - 100), 0 from regladefinicion r, definicioncuenta defcta where r.definicion_id = defcta.id and defcta.codigo = 'CPVR1';
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) select (select id from definicioncuenta where codigo = 'CPVR1'), r.transaccion_id, (r.maximo_diario - 100), (r.maximo_operacion - 150), 0 from regladefinicion r, definicioncuenta defcta where r.definicion_id = defcta.id and defcta.codigo = 'CPVR1';
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) select (select id from definicioncuenta where codigo = 'CPVR2'), r.transaccion_id, (r.maximo_diario + 250), (r.maximo_operacion + 100), 0 from regladefinicion r, definicioncuenta defcta where r.definicion_id = defcta.id and defcta.codigo = 'CPVR1';
INSERT INTO regladefinicion (definicion_id, transaccion_id, maximo_diario, maximo_operacion, origen) select (select id from definicioncuenta where codigo = 'CPVR3'), r.transaccion_id, (r.maximo_diario + 500), (r.maximo_operacion + 250), 0 from regladefinicion r, definicioncuenta defcta where r.definicion_id = defcta.id and defcta.codigo = 'CPVR1';