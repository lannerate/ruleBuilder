package com.flagleader.builder.dialogs;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a.a.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.r;
import java.net.URL;
import java.net.URLConnection;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class o extends f
{
  private String d;
  private String e;
  private int f;
  private int g;
  protected Text a;
  protected Text b;
  protected Text c;
  private Button h;
  private boolean i = true;
  private BuilderManager j;

  public o(BuilderManager paramBuilderManager)
  {
    super(Display.getCurrent().getActiveShell());
    this.j = paramBuilderManager;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    getShell().setText(b("title.LoginDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(2));
    localComposite2.setLayoutData(a(240, 60));
    a(localComposite2, "UserName.LoginDialog").setLayoutData(b(60));
    this.a = a(localComposite2, 2048);
    this.a.setLayoutData(b(160));
    a(localComposite2, "Password.LoginDialog").setLayoutData(b(60));
    this.b = a(localComposite2, 67584);
    this.b.setLayoutData(b(160));
    this.b.setEchoChar('*');
    this.a.setText(b.a().x());
    this.b.setText(b.a().w());
    if ((this.j.isMainApplication()) && (!this.j.isWebEditor()))
    {
      Composite localComposite3 = new Composite(localComposite1, 0);
      localComposite3.setLayout(a(1));
      this.h = a(localComposite3, "ruleServiceUrl.SetDialog", 32);
      this.h.setSelection(b.a().I());
      this.h.addSelectionListener(new p(this));
      this.c = a(localComposite3, 2048);
      this.c.setLayoutData(b(220));
      this.c.setText(b.a().H());
      this.c.setEditable(b.a().I());
    }
    return localComposite1;
  }

  protected void okPressed()
  {
    if ((this.c != null) && (this.c.getText() != null) && (this.c.getText().length() > 0) && (this.h.getSelection()))
    {
      try
      {
        URL localURL = new URL(this.c.getText());
        URLConnection localURLConnection = localURL.openConnection();
        localURLConnection.connect();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        MessageDialog.openError(null, b("error.LoginDialog"), localException.getLocalizedMessage());
        return;
      }
      this.j.getRulesManager().a(null, 0, 0);
    }
    if ((this.j.isMainApplication()) && (!this.j.isWebEditor()))
    {
      b.a().i(this.h.getSelection());
      if (!b.a().H().equals(this.c.getText()))
      {
        b.a().v(this.c.getText());
        b.a().b();
      }
    }
    this.d = this.a.getText();
    this.e = this.b.getText();
    String str = e();
    if ((str != null) && (str.length() > 0))
    {
      MessageDialog.openError(null, b("error.LoginDialog"), str);
      return;
    }
    super.okPressed();
  }

  private String e()
  {
    try
    {
      d locald = this.j.getRulesManager().o();
      this.f = locald.a(this.d, this.e);
      this.g = locald.d();
      if (this.f == 0)
        return locald.i();
      return null;
    }
    catch (Exception localException)
    {
    }
    return " " + localException.getMessage();
  }

  public String a()
  {
    return this.d;
  }

  public String b()
  {
    return this.e;
  }

  public int c()
  {
    return this.f;
  }

  public int d()
  {
    return this.g;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.o
 * JD-Core Version:    0.6.0
 */