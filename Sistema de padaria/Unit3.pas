unit Unit3;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Menus, jpeg, ExtCtrls;

type
  Tmmenu = class(TForm)
    MainMenu1: TMainMenu;
    Incio1: TMenuItem;
    Usuarios1: TMenuItem;
    Produtos1: TMenuItem;
    N1: TMenuItem;
    Sair1: TMenuItem;
    Image1: TImage;
    Produtos2: TMenuItem;
    Consulta1: TMenuItem;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure Sair1Click(Sender: TObject);
    procedure Usuarios1Click(Sender: TObject);
    procedure FormCreate(Sender: TObject);
    procedure Produtos1Click(Sender: TObject);
    procedure Consulta1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  mmenu: Tmmenu;

implementation

uses Unit1, Unit4, Unit5, Unit6;

{$R *.dfm}

procedure Tmmenu.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  log.Show;
end;

procedure Tmmenu.Sair1Click(Sender: TObject);
begin
  mmenu.Close;
  mmenu := NIL;
  log.Show;
end;

procedure Tmmenu.Usuarios1Click(Sender: TObject);
begin
  if (cad = NIL) then
    begin
      cad := Tcad.Create(self);
      cad.Show;
    end
  else
    begin
      cad.Show;
    end;
end;

procedure Tmmenu.FormCreate(Sender: TObject);
begin
  if (UpperCase(log.tipo) = 'ADMN') then
    begin
      Usuarios1.Enabled := true;
    end
  else
    begin
      Usuarios1.Enabled := false;
    end;
end;

procedure Tmmenu.Produtos1Click(Sender: TObject);
begin
  if (produ = NIL) then
    begin
      produ := Tprodu.Create(self);
      produ.Show;
    end
  else
    begin
      produ.Show;
    end;
end;

procedure Tmmenu.Consulta1Click(Sender: TObject);
begin
  if f_consulta = NIL then
    begin
      f_consulta := Tf_consulta.Create(Self);
      f_consulta.Show;
    end
  else
    begin
      f_consulta.Show;
    end
end;

end.
