class HangpersonGame

  # add the necessary class methods, attributes, etc. here
  # to make the tests in spec/hangperson_game_spec.rb pass.

  # Get a word from remote "random word" service

  # def initialize()
  # end
  
  attr_accessor :word, :guesses, :wrong_guesses

  class InvalidGuessError < StandardError; end

  def initialize(word)
    @word = word
    @guesses = ''
    @wrong_guesses = ''
  end

  def guess(value)
    raise ArgumentError, "invalid input" if value.nil? || !value.match?(/[a-zA-z]/) || value.empty?
    # downcase value
    value.downcase!
    # if value exists in @guesses and @wrong_guesses, return false
    if @guesses.include?(value) || @wrong_guesses.include?(value)
      raise HangpersonGame::InvalidGuessError
    end
    #if they dont exist, then check if the word consist the guessed letter. 
    # if word consists, then add word to @guesses, return true?
    if @word.include?(value)
      @guesses << value
    else
      #if word not inside, then add word to @wrong_guesses
      @wrong_guesses << value
    end
    return true
  end

  def check_win_or_lose
    if word.chars.all? { |char| @guesses.include?(char) }
      :win
    elsif @wrong_guesses.length == 7
      :lose
    else
      :play
    end
  end

  def word_with_guesses
    guessed_set = @guesses.chars.to_set
    @word.chars.map { |char| guessed_set.include?(char) ? char : '-' }.join
  end

  # You can test it by installing irb via $ gem install irb
  # and then running $ irb -I. -r app.rb
  # And then in the irb: irb(main):001:0> HangpersonGame.get_random_word
  #  => "cooking"   <-- some random word
  def self.get_random_word
    require 'uri'
    require 'net/http'
    uri = URI('http://randomword.saasbook.info/RandomWord')
    Net::HTTP.new('randomword.saasbook.info').start { |http|
      return http.post(uri, "").body
    }
  end
end
