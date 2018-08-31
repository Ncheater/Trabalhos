unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls, DB, ADODB;

type
  Tlog = class(TForm)
    ADOConnection1: TADOConnection;
    ADOQuery1: TADOQuery;
    ADOQuery1id_usu: TAutoIncField;
    ADOQuery1login_usu: TStringField;
    ADOQuery1senha_usu: TStringField;
    usu: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    senha: TEdit;
    acessar: TButton;
    esenha: TButton;
    ADOQuery1nome_usu: TStringField;
    ADOQuery1tel_usu: TLargeintField;
    ADOQuery1tipo_usu: TStringField;
    procedure acessarClick(Sender: TObject);
    procedure esenhaClick(Sender: TObject);
  private
    { Private declarations }
  public
    idl: Integer;
    tipo: String;
    { Public declarations }
  end;

var
  log: Tlog;

implementation

uses Unit2, Unit3;

{$R *.dfm}

procedure Tlog.acessarClick(Sender: TObject);
begin
  ADOQuery1.Close;
  ADOQuery1.SQL.Text := 'SELECT * FROM padaria.tb_usuario WHERE login_usu = '+QuotedStr(usu.Text)+' AND senha_usu = '+QuotedStr(senha.Text);
  ADOQuery1.Open;
  if (not ADOQuery1id_usu.IsNull) then
    begin
      idl := ADOQuery1id_usu.AsInteger;
      tipo := ADOQuery1tipo_usu.AsString;
      if (menu = NIL) then
        begin
          mmenu := Tmmenu.Create(self);
          mmenu.Show;
          log.Hide;
          log.usu.Text := '';
          log.senha.Text := '';
        end
      else
        begin
          mmenu.Show;
          log.Hide;
          log.usu.Text := '';
          log.senha.Text := '';
        end;

    end
  else
    begin
      ShowMessage('Usu�rio inexistente');
    end;
  end;

procedure Tlog.esenhaClick(Sender: TObject);
begin
  ADOQuery1.Close;
  ADOQuery1.SQL.Text := 'SELECT * FROM padaria.tb_usuario WHERE login_usu = '+QuotedStr(usu.Text);
  ADOQuery1.Open;
  idl := ADOQuery1id_usu.AsInteger;
  if (nsenha = NIL) then
    begin
      nsenha := Tnsenha.Create(self);
      nsenha.ShowModal;
    end
  else
    begin
      nsenha.ShowModal;
    end;
end;

end.
