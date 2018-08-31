unit Unit3;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, Menus, jpeg, ExtCtrls;

type
  Tmmenu = class(TForm)
    MainMenu1: TMainMenu;
    Incio1: TMenuItem;
    Usurios1: TMenuItem;
    Produtos1: TMenuItem;
    N1: TMenuItem;
    Sair1: TMenuItem;
    Image1: TImage;
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
    procedure Sair1Click(Sender: TObject);
    procedure Usurios1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  mmenu: Tmmenu;

implementation

uses Unit1, Unit4;

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

procedure Tmmenu.Usurios1Click(Sender: TObject);
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

end.
