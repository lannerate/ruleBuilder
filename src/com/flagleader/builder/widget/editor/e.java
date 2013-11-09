package com.flagleader.builder.widget.editor;

import com.flagleader.builder.widget.editor.d.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.NumberRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class e extends RuleBasedScanner
{
  public static final String a = "Comment";
  public static final String b = "Keyword";
  public static final String c = "String";
  public static final String d = "Object";
  protected TextAttribute e;
  protected TextAttribute f;
  protected TextAttribute g;
  protected TextAttribute h;
  protected TextAttribute i;
  protected TextAttribute j;
  protected TextAttribute k;
  protected TextAttribute l;
  protected TextAttribute m;
  private m o;
  protected s n;

  public e(s params)
  {
    this.n = params;
    this.o = params.m();
    a();
    b();
  }

  protected void a()
  {
    this.e = new TextAttribute(d.j[7], null, 1);
    this.f = new TextAttribute(d.j[6]);
    this.g = new TextAttribute(d.j[3]);
    this.h = new TextAttribute(d.j[8], null, 2);
    this.i = new TextAttribute(d.j[4]);
    this.j = new TextAttribute(d.j[9]);
    this.k = new TextAttribute(d.j[1], null, 1);
    this.l = new TextAttribute(d.j[1]);
    this.m = new TextAttribute(d.j[7]);
  }

  public IToken nextToken()
  {
    this.fTokenOffset = this.fOffset;
    this.fColumn = -1;
    if (this.o.a(this.fOffset))
    {
      while (this.o.a(this.fOffset))
        if (read() == -1)
          return Token.EOF;
      return new Token(this.i);
    }
    if (this.o.b(this.fOffset))
    {
      while (this.o.b(this.fOffset))
        if (read() == -1)
          break;
      return new Token(this.h);
    }
    if (this.fRules != null)
      for (i1 = 0; i1 < this.fRules.length; i1++)
      {
        IToken localIToken = this.fRules[i1].evaluate(this);
        if (!localIToken.isUndefined())
          return localIToken;
      }
    int i1 = read();
    if (i1 == -1)
      return Token.EOF;
    if ((this.fRules != null) && (Character.isJavaIdentifierStart((char)i1)))
    {
      while ((i1 != -1) && (Character.isJavaIdentifierPart((char)i1)))
        i1 = read();
      unread();
    }
    return this.fDefaultReturnToken;
  }

  protected void b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new SingleLineRule("\"", "\"", new Token(this.f), '\\'));
    localArrayList.add(new SingleLineRule("'", "'", new Token(this.f), '\\'));
    localArrayList.add(new SingleLineRule("/*", "*/", new Token(this.h), '\\'));
    localArrayList.add(new EndOfLineRule("//", new Token(this.h), '\\'));
    localArrayList.add(new WhitespaceRule(new f(this)));
    localArrayList.add(new NumberRule(new Token(this.l)));
    Iterator localIterator = this.n.s().a();
    if (localIterator != null)
    {
      localObject = new c(new F(this.n.s()), c());
      while (localIterator.hasNext())
        ((c)localObject).a((String)localIterator.next(), new Token(this.e));
      localArrayList.add(localObject);
    }
    localIterator = this.n.s().b();
    if (localIterator != null)
    {
      localObject = new c(new H(this.n.s()), c());
      while (localIterator.hasNext())
        ((c)localObject).a((String)localIterator.next(), new Token(this.j));
      localArrayList.add(localObject);
    }
    else
    {
      localArrayList.add(new b(new Token(this.j)));
    }
    localIterator = this.n.s().c();
    if (localIterator != null)
    {
      localObject = new c(new a(this.n.s()), c());
      while (localIterator.hasNext())
        ((c)localObject).a((String)localIterator.next(), new Token(this.k));
      localArrayList.add(localObject);
    }
    localIterator = this.n.t().a();
    if (localIterator != null)
    {
      localObject = new c(new G(this.n.t()), c());
      while (localIterator.hasNext())
        ((c)localObject).a((String)localIterator.next(), new Token(this.g));
      localArrayList.add(localObject);
    }
    localIterator = this.n.t().b();
    if (localIterator != null)
    {
      localObject = new c(new G(this.n.t()), c());
      while (localIterator.hasNext())
        ((c)localObject).a((String)localIterator.next(), new Token(this.m));
      localArrayList.add(localObject);
    }
    Object localObject = new IRule[localArrayList.size()];
    localArrayList.toArray(localObject);
    setRules(localObject);
  }

  protected boolean c()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.e
 * JD-Core Version:    0.6.0
 */