unit Unit3;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs;

type
  Tmmenu = class(TForm)
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  mmenu: Tmmenu;

implementation

uses Unit1;

{$R *.dfm}

procedure Tmmenu.FormClose(Sender: TObject; var Action: TCloseAction);
begin
  log.Show;
end;

end.
