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
