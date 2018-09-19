unit Unit6;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Grids, DBGrids, StdCtrls, DB, ADODB;

type
  Tf_consulta = class(TForm)
    DBGrid1: TDBGrid;
    GroupBox1: TGroupBox;
    pesquisa: TButton;
    id: TEdit;
    nome: TEdit;
    rbt_id: TRadioButton;
    rbt_nome: TRadioButton;
    ADOConnection1: TADOConnection;
    ADOQuery1: TADOQuery;
    DataSource1: TDataSource;
    ADOQuery1id_prod: TAutoIncField;
    ADOQuery1preco_prod: TBCDField;
    ADOQuery1nome_prod: TStringField;
    procedure rbt_idClick(Sender: TObject);
    procedure pesquisaClick(Sender: TObject);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  f_consulta: Tf_consulta;

implementation

{$R *.dfm}

procedure Tf_consulta.rbt_idClick(Sender: TObject);
begin
  if rbt_id.Checked then
    begin
      id.Enabled := true;
      nome.Enabled := false;
      nome.Text := '';
    end

  else if rbt_nome.Checked then
    begin
      id.Enabled := false;
      id.Text := '';
      nome.Enabled := true;
    end




end;

procedure Tf_consulta.pesquisaClick(Sender: TObject);
begin
    if rbt_id.Checked then
      begin
        with ADOQuery1 do
          begin
            Close;
            SQL.Text := 'SELECT * FROM padaria.tb_produto WHERE id_prod = '+ QuotedStr(id.Text);
            Open;
          end;
      end
    else if rbt_nome.Checked then
      begin
         with ADOQuery1 do
          begin
            Close;
            SQL.Text := 'SELECT * FROM padaria.tb_produto WHERE nome_prod = '+ QuotedStr(nome.Text);
            Open;
          end;

      end
    else
      begin
        ShowMessage('Por favor selecione o campo desejado');
      end;

end;

procedure Tf_consulta.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  f_consulta := NIL;
end;

end.
