unit Unit4;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Grids, DBGrids, DB, StdCtrls, Mask, DBCtrls, ExtCtrls, ADODB;

type
  Tcad = class(TForm)
    GroupBox1: TGroupBox;
    ADOConnection1: TADOConnection;
    ADOQuery1: TADOQuery;
    ADOQuery1id_usu: TAutoIncField;
    ADOQuery1login_usu: TStringField;
    ADOQuery1senha_usu: TStringField;
    admin: TRadioGroup;
    Button1: TButton;
    ADOQuery1nome_usu: TStringField;
    Label1: TLabel;
    DataSource1: TDataSource;
    Label2: TLabel;
    DBEdit2: TDBEdit;
    Label3: TLabel;
    DBEdit3: TDBEdit;
    DBGrid1: TDBGrid;
    Button2: TButton;
    ADOQuery1tel_usu: TLargeintField;
    ADOQuery1tipo_usu: TStringField;
    DBEdit1: TDBEdit;
    procedure Button1Click(Sender: TObject);
    procedure Button2Click(Sender: TObject);
    procedure DBGrid1CellClick(Column: TColumn);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    sure: boolean;
    { Private declarations }
  public
    { Public declarations }
  end;

var
  cad: Tcad;

implementation

{$R *.dfm}

procedure Tcad.Button1Click(Sender: TObject);
begin
  if (admin.ItemIndex = -1) then
    begin
      ShowMessage('Por favor selecione o tipo de usuário');
    end
  else
    begin
      if (admin.ItemIndex = 0) then
        begin
          ADOQuery1tipo_usu.AsString := 'ADMN';
          ADOQuery1.Insert;
        end
      else
        begin
          ADOQuery1tipo_usu.AsString := 'VEND';
          ADOQuery1.Insert;
        end;
    end;
end;

procedure Tcad.Button2Click(Sender: TObject);
begin
  if (sure) then
    begin
      ADOQuery1.Delete;
      sure := False;
    end;
  ShowMessage('Clique novamente para remover o usuário '+ADOQuery1nome_usu.AsString);
  sure := True;
end;

procedure Tcad.DBGrid1CellClick(Column: TColumn);
begin
  sure := False;
end;

procedure Tcad.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  cad := NIL;
end;

end.
